public void DOMParser(String xmlString) {
 
    try {
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xmlString));
 
        Document doc = db.parse(is);
        NodeList nodes = doc.getElementsByTagName("book");
 
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
 
            NodeList name = element.getElementsByTagName("name");
            Element line = (Element) name.item(0);
            System.out.println(getCharacterDataFromElement(line));
 
            NodeList author = element.getElementsByTagName("author");
            line = (Element) author.item(0);
            System.out.println(getCharacterDataFromElement(line));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
 
}
 
private String getCharacterDataFromElement(Element e) {
    Node child = e.getFirstChild();
    if (child instanceof CharacterData) {
        CharacterData cd = (CharacterData) child;
        return cd.getData();
    }
    return "";
}
