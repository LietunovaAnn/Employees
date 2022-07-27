package org.example.controller;

import org.example.dao.DAOFactory;
import org.example.dao.EmployeesDAOImpl;
import org.example.dao.OracleDAOFactoryImpl;
import org.example.view.RemoveEmployeeView;

public class RemoveEmployeeController extends Controller {
    private final RemoveEmployeeView view;

    public RemoveEmployeeController(RemoveEmployeeView view, int actionToPerform) {
        super(view, actionToPerform);
        this.view = view;
    }

    public void removeEmployee() {
        int empno = view.printInfo();

        DAOFactory factory = OracleDAOFactoryImpl.getInstance();
        EmployeesDAOImpl employeesDAO = factory.getEmployeesDAO();
        if(employeesDAO.getEmployee(empno) == null) {
            view.printResult("Нет такого сотрудника");
        } else {
            employeesDAO.removeEmployee(empno);
            view.printResult("Сотрудник удален");
        }
    }

    @Override
    public int process() {
        removeEmployee();
        return super.process();
    }
}
