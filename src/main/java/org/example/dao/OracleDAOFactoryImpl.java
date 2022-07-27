package org.example.dao;

import org.example.model.xml.DataSource;

import java.sql.*;

public class OracleDAOFactoryImpl implements DAOFactory {

    public static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    public static final String DB_USERNAME = "hanna";
    public static final String DB_PASSWORD = "parol1";
    public static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static Connection connection;

    public static OracleDAOFactoryImpl instance;

    private OracleDAOFactoryImpl () {
    }

    public static OracleDAOFactoryImpl getInstance(){
        if (instance == null) {
            return new OracleDAOFactoryImpl();
        }
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
