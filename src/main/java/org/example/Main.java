package org.example;

import org.example.controller.Controller;
import org.example.controller.MainController;
import org.example.dao.DAOFactory;
import org.example.dao.OracleDAOFactoryImpl;
import org.example.model.xml.DataSources;
import org.example.controller.jaxb.JaxbConvertetion;
import org.example.view.MainView;

public class Main {
    public static void main(String[] args) {

        DataSources dataSources = JaxbConvertetion.jaxbXmlFileToObject("src/main/resources/dataSourceConnect.xml");


        DAOFactory factory = new OracleDAOFactoryImpl(dataSources.getDataSource());
        factory.connect();

        MainView mainView = new MainView();
        Controller mainController = new MainController(mainView);
        mainController.process();

        factory.disconnect();
    }
}