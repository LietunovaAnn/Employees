package org.example.dao;

import org.example.model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDAOImpl {
    private final static Connection connection = OracleDAOFactoryImpl.getConnection();


    public Department getDepartment (int depno) {
        ResultSet resultSet = null;
        Department department = null;
        try {
            assert connection != null;
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("select LOC, DNAME from DEPT where DEPTNO=?" )) {
                preparedStatement.setInt(1, depno);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    department = parseDepartment(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return department;
    }

    private Department parseDepartment(ResultSet resultSet){
        Department department = new Department();
        try {
            String loc = resultSet.getString(1);
            String dname = resultSet.getString(2);
            department.setLoc(loc);
            department.setDname(dname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

}
