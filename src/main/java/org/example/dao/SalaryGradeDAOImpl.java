package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryGradeDAOImpl {
    private final static Connection connection = OracleDAOFactoryImpl.getConnection();

    public float getSalaryGradeEmployee(float sal) {
        ResultSet resultSet = null;
        int grade = 0;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("select GRADE from SALGRADE where ? BETWEEN minsal and hisal")) {
            preparedStatement.setFloat(1, sal);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                grade = parseSalaryGrade(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return grade;
    }

    private int parseSalaryGrade(ResultSet resultSet) {
        int grade = 0;
        try {
            grade = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade;
    }
}
