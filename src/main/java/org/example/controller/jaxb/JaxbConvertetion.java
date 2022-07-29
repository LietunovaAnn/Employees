package org.example.controller.jaxb;

import org.example.model.xml.DataSources;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class JaxbConvertetion {
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




