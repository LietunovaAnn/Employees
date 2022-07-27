package org.example.controller;


import org.example.dao.*;
import org.example.model.entities.Department;
import org.example.model.entities.Employee;
import org.example.view.InfoEmployeeView;

public class InfoEmployeeController extends Controller {

    private final InfoEmployeeView view;

    public InfoEmployeeController(InfoEmployeeView view, int actionToPerform) {
        super(view, actionToPerform);
        this.view = view;
    }

    public void infoEmployeeByEmpno() {
        int empno = view.readEmpnoEmployee();

        DAOFactory factory = OracleDAOFactoryImpl.getInstance();
        EmployeesDAOImpl employeesDAO = factory.getEmployeesDAO();
        Employee employee = employeesDAO.getEmployee(empno);
        if (employee == null) {
            System.out.println("Нет такого сотрудника.");
            infoEmployeeByEmpno();
            return;
        }
        DepartmentDAOImpl departmentDAO = factory.getDepartmentDAO();
        Department department = departmentDAO.getDepartment(employee.getDepno());
        SalaryGradeDAOImpl salaryGradeDAO = factory.getSalaryGradeDAO();
        float sal = salaryGradeDAO.getSalaryGradeEmployee(employee.getSal());


        String info = infoEmployee(employee, department, sal);
        view.printResult(info);

    }

    public String infoEmployee(Employee employee, Department department, float sal) {
        StringBuilder sb = new StringBuilder("Информация сотрудника\n")
                .append(employee.toString()).append("\n")
                .append("место работы ").append(department.getLoc()).append("\n")
                .append("название подразделения ").append(department.getDname()).append("\n")
                .append("розряд ЕТС ").append(sal);

        return String.valueOf(sb);
    }

    @Override
    public int process() {
        infoEmployeeByEmpno();
        return super.process();
    }
}
