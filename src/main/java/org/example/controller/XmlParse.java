package org.example.controller;

import org.example.model.xml.DataSources;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class XmlParse {
    public static DataSources jaxbXmlFileToObject(String file) {
        DataSources dataSources = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DataSources.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            System.setProperty("javax.xml.accessExternalDTD", "all");
            dataSources = (DataSources) jaxbUnmarshaller.unmarshal(new File(file));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return dataSources;
    }
}




