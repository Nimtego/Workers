package DOM;

import Employer.Employer;
import Employer.TypeEmployer;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DomExample {
    public static void generateXML(Map<TypeEmployer, List<Employer>> mapEmployer) {
        try {
/*            final String fileName = "BookCatalogue.xml";
            XMLStreamReader xmlStreamReader = XMLInputFactory.newInstance().
                    createXMLStreamReader(fileName, new FileInputStream(fileName));
            while (xmlStreamReader.hasNext()) {
                xmlStreamReader.hasNext();
                if (xmlStreamReader.isStartElement()) {
                    System.out.println(xmlStreamReader.getLocalName());
                } else if (xmlStreamReader.isEndElement()) {
                    System.out.println("/" + xmlStreamReader.getLocalName());
                } else if (xmlStreamReader.hasText() && xmlStreamReader.getText().trim().length() > 0) {
                    System.out.println("   " + xmlStreamReader.getText());
                }
            }*/
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("EmployerSQL.xml");

            // Вызываем метод для добавления новой книги
            addNewBook(document, mapEmployer);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    // Функция добавления новой книги и записи результата в файл
    public static void addNewBook(Document document, Map<TypeEmployer, List<Employer>> mapEmployer)
                                                    throws TransformerFactoryConfigurationError, DOMException {
        Node root = document.getDocumentElement();      // Получаем корневой элемент
        for (TypeEmployer key : mapEmployer.keySet()) {
            Element employer = document.createElement(String.valueOf(key));
            for (Employer emp : mapEmployer.get(key)) {
                // Создаем новую книгу по элементам
                // Сама книга <Book>
                Element id = document.createElement("ID"); //ID
                id.setTextContent(String.valueOf(emp.getId())); // Устанавливаем значение ID
                Element name = document.createElement("Name");
                name.setTextContent(emp.getName());
                Element surName = document.createElement("Surname");
                surName.setTextContent(emp.getSurname());
                Element age = document.createElement("Age");
                age.setTextContent(String.valueOf(emp.getAge()));
                Element dateOfBirth = document.createElement("Date_of_birth");
                dateOfBirth.setTextContent(emp.getDateOfBirth());
                Element dateOfAcceptance = document.createElement("Date_of_acceptance");
                dateOfAcceptance.setTextContent(emp.getDateOfAcceptance());
                Element description = document.createElement("Description");
                description.setTextContent(emp.getDescription());

                employer.appendChild(id);
                employer.appendChild(name);
                employer.appendChild(surName);
                employer.appendChild(age);
                employer.appendChild(dateOfBirth);
                employer.appendChild(dateOfAcceptance);
                employer.appendChild(description);

                root.appendChild(employer);

                writeDocument(document);
            }
        }
    }

    // Функция для сохранения DOM в файл
    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream("other2.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
