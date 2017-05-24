import Employer.EmployerFabric;
import Employer.Organization;
import View.View;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static DOM.DomExample.generateXML;

/**
 * Created by myasnikov
 * on 23.05.2017.
 */
public class Solution {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Organization organization = new Organization();
        for (int i = 0; i < 10; i++) {
            organization.addEmployer(EmployerFabric.generateEmployer());
            View.print(organization);
        }
        generateXML(organization.getListEmployer());

    }
/*    public static void test(final String fileName) throws ParserConfigurationException, SAXException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Здесь мы определили анонимный класс, расширяющий класс DefaultHandler
            DefaultHandler handler = new DefaultHandler() {
                // Поле для указания, что тэг NAME начался
                boolean name = false;

                // Метод вызывается когда SAXParser "натыкается" на начало тэга
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    // Если тэг имеет имя NAME, то мы этот момент отмечаем - начался тэг NAME
                    if (qName.equalsIgnoreCase("Type")) {
                        name = true;
                    }
                }

                // Метод вызывается когда SAXParser считывает текст между тэгами
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    // Если перед этим мы отметили, что имя тэга NAME - значит нам надо текст использовать.
                    if (name) {
                        System.out.println("Type: " + new String(ch, start, length));
                        name = false;
                    }
                }
            };

            // Стартуем разбор методом parse, которому передаем наследника от DefaultHandler, который будет вызываться в нужные моменты
            saxParser.parse(fileName, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}

/**
 public class SaxExample {

 public static void main(String args[]) {

 // Имя файла
 final String fileName = "Phonebook.xml";

 try {
 SAXParserFactory factory = SAXParserFactory.newInstance();
 SAXParser saxParser = factory.newSAXParser();

 // Здесь мы определили анонимный класс, расширяющий класс DefaultHandler
 DefaultHandler handler = new DefaultHandler() {
 // Поле для указания, что тэг NAME начался
 boolean name = false;

 // Метод вызывается когда SAXParser "натыкается" на начало тэга
 @Override
 public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
 // Если тэг имеет имя NAME, то мы этот момент отмечаем - начался тэг NAME
 if (qName.equalsIgnoreCase("NAME")) {
 name = true;
 }
 }

 // Метод вызывается когда SAXParser считывает текст между тэгами
 @Override
 public void characters(char ch[], int start, int length) throws SAXException {
 // Если перед этим мы отметили, что имя тэга NAME - значит нам надо текст использовать.
 if (name) {
 System.out.println("Name: " + new String(ch, start, length));
 name = false;
 }
 }
 };

 // Стартуем разбор методом parse, которому передаем наследника от DefaultHandler, который будет вызываться в нужные моменты
 saxParser.parse(fileName, handler);

 } catch (Exception e) {
 e.printStackTrace();
 }
 }
 } **/