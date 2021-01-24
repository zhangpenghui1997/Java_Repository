import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.math.BigDecimal;
import java.util.List;

public class Dom4jTest {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("xml11_12/xml/books.xml");
        //System.out.println(document);
        Element rootElement = document.getRootElement();
        //System.out.println(rootElement);
        List<Element> books = rootElement.elements("book");
        for (Element book : books) {
            //System.out.println(book.asXML());
            Element name = book.element("name");
            //System.out.println(name.asXML());
            //System.out.println(name.getText());
            String nameText=book.elementText("name");
            String authorText=book.elementText("author");
            String priceText=book.elementText("price");
            String otherText=book.elementText("other");
            String sn=book.attributeValue("sn");
            System.out.println(new Book(nameText,Double.parseDouble(priceText),authorText,sn,otherText).toString());
        }


    }
}
