package org.example.model.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlParse {
    private static final String TAG_DATA_SOURSE = "datasource";
    private static final String TAG_SOURSE_NAME = "source-name";
    private static final String TAG_CONNECTION_URL = "connection-url";
    private static final String TAG_DRIVER_CLASS = "driver-class";
    private static final String TAG_USER_NAME = "user-name";
    private static final String TAG_PASSWORD = "password";


    public static DataSource domXmlParse() {
//src/main/resources/students.xml

        File xmlFile = new File("src/main/resources/dataSource.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document document = null;
        DataSource dataSource = null;
        try {
            builder = factory.newDocumentBuilder();
            document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName(TAG_DATA_SOURSE);
            dataSource = getDataSource((Node) nodeList);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println("Нет соединения с БД");
        }
        return dataSource;
    }

    private static DataSource getDataSource(Node node) {
        DataSource dataSource = new DataSource();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            dataSource.setSourcename(getTagValue(TAG_SOURSE_NAME, element));
            dataSource.setConnectionurl(getTagValue(TAG_CONNECTION_URL, element));
            dataSource.setDriverclass(getTagValue(TAG_DRIVER_CLASS, element));
            dataSource.setUsername(getTagValue(TAG_USER_NAME, element));
            dataSource.setPassword(getTagValue(TAG_PASSWORD, element));
        }
        return dataSource;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

}




