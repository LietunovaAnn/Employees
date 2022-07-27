package org.example.dao;

import org.example.model.entities.Employee;

import java.sql.*;
import java.time.LocalDate;


public class EmployeesDAOImpl  {

    private final static Connection connection = OracleDAOFactoryImpl.getConnection();

    public Employee getEmployee (int empno) {
        ResultSet resultSet = null;
        Employee employee = null;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM EMP WHERE EMPNO = ?" )) {
            preparedStatement.setInt(1, empno);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = parseEmployee(resultSet);
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
        return employee;
    }

    private Employee parseEmployee(ResultSet resultSet) {
        Employee employee;
        try {
            int empno = resultSet.getInt(1);
            String ename = resultSet.getString(2);
            String job = resultSet.getString(3);
            int mgr = resultSet.getInt(4);
            LocalDate hiredate = resultSet.getDate(5).toLocalDate();
            float sal = resultSet.getFloat(6);
            float comm = resultSet.getFloat(7);
            int depno = resultSet.getInt(8);
            employee = new Employee(empno, ename, job, mgr, hiredate, sal, comm, depno);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }


    public boolean addEmployee(Employee employee) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO EMP VALUES (?, ?, ?, ?, ?, ?, ?, ?) ");) {
            preparedStatement.setInt(1, employee.getEmpno());
            preparedStatement.setString(2, employee.getEname());
            preparedStatement.setString(3, employee.getJob());
            preparedStatement.setInt(4, employee.getMgr());
            preparedStatement.setDate(5, Date.valueOf(employee.getHiredate()));
            preparedStatement.setFloat(6, employee.getSal());
            preparedStatement.setFloat(7, employee.getComm());
            preparedStatement.setInt(8, employee.getDepno());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }





    public boolean removeEmployee(int empno) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE EMP WHERE EMPNO = ?") ;){
            preparedStatement.setInt(1, empno);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

