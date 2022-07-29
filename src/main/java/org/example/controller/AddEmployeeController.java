package org.example.controller;

import org.example.dao.DAOFactory;
import org.example.dao.EmployeesDAOImpl;
import org.example.dao.OracleDAOFactoryImpl;
import org.example.view.AddEmployeeView;

public class AddEmployeeController extends Controller {
    private final AddEmployeeView view;

    public AddEmployeeController(AddEmployeeView view, int actionToPerform) {
        super(view, actionToPerform);
        this.view = view;
    }

    public void addNewEmployee() {
        DAOFactory factory = OracleDAOFactoryImpl.getInstance();

        EmployeesDAOImpl employeesDAO = factory.getEmployeesDAO();
        boolean isEmployeeAdded = employeesDAO.addEmployee(view.readNewEmployee());
        view.printResult(isEmployeeAdded ? "успешно добавлен" : "не добавлен");
    }

    @Override
    public int process() {
        addNewEmployee();
        return super.process();
    }
}
