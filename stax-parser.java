
public void StAXParser(String xmlString) {
 
    String name = "";
    String author = "";
 
    try {
 
        XMLInputFactory xif = XMLInputFactory.newInstance();
        XMLStreamReader streamReader = xif.createXMLStreamReader(new StringReader(xmlString));
 
        while (streamReader.hasNext()) {
            streamReader.next();
            if (streamReader.getEventType() == XMLStreamReader.START_ELEMENT) {
 
                if (streamReader.getLocalName() == "name") {
                    name = streamReader.getElementText();
                    System.out.println(name);
                } else if (streamReader.getLocalName() == "author") {
                    author = streamReader.getElementText();
                    System.out.println(author);
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }     
}
