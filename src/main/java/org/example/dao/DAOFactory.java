package org.example.dao;

public interface DAOFactory extends AutoCloseable{
    void connect();
    void disconnect();
    EmployeesDAOImpl getEmployeesDAO();
    DepartmentDAOImpl getDepartmentDAO();
    SalaryGradeDAOImpl getSalaryGradeDAO();
}
