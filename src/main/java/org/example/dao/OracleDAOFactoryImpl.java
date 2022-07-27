package org.example.dao;

import org.example.model.xml.DataSource;
import org.example.model.xml.DataSources;

import java.sql.*;

public class OracleDAOFactoryImpl implements DAOFactory {

    public final String DB_URL ;
    public final String DB_USERNAME ;
    public final String DB_PASSWORD ;
    public final String DRIVER  ;
    private static Connection connection;

    public static OracleDAOFactoryImpl instance;

    public OracleDAOFactoryImpl (DataSource dataSource) {
        DB_URL = dataSource.getConnectionurl();
        DB_USERNAME = dataSource.getUsername();
        DB_PASSWORD = dataSource.getPassword();
        DRIVER = dataSource.getDriverclass();
    }

    public static OracleDAOFactoryImpl getInstance(){
        return instance;
    }

    @Override
    public void connect() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static Connection getConnection() {
        try {
            if (!connection.isClosed())    {
                return connection;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeesDAOImpl getEmployeesDAO() {
        return new EmployeesDAOImpl();
    }

    @Override
    public DepartmentDAOImpl getDepartmentDAO() {
        return new DepartmentDAOImpl();
    }

    @Override
    public SalaryGradeDAOImpl getSalaryGradeDAO() {
        return new SalaryGradeDAOImpl();
    }

    @Override
    public void close() throws Exception {
        disconnect();
    }
}
