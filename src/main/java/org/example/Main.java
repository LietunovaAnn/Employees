package org.example;

import org.example.controller.Controller;
import org.example.controller.MainController;
import org.example.dao.DAOFactory;
import org.example.dao.OracleDAOFactoryImpl;
import org.example.model.xml.DataSource;
import org.example.model.xml.XmlParse;
import org.example.view.MainView;

public class Main {
    public static void main(String[] args) {

        DataSource dataSource = XmlParse.domXmlParse();
        System.out.println(dataSource);

//        DAOFactory factory = OracleDAOFactoryImpl.getInstance();
//        factory.connect();
//
//        MainView mainView = new MainView();
//        Controller mainController = new MainController(mainView);
//        mainController.process();
//
//        factory.disconnect();
    }
}