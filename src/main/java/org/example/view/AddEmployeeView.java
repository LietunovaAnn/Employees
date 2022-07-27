package org.example.view;


import org.example.model.entities.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddEmployeeView implements View {
    private static final Scanner scanner = new Scanner(System.in);

    public Employee readNewEmployee() {
        Employee employee = new Employee();

        System.out.println("Введите номер сотрудника:");
        employee.setEmpno(Integer.parseInt(scanner.nextLine()));

        System.out.println("Введите имя:");
        employee.setEname(scanner.nextLine());

        System.out.println("Введите должность:");
        employee.setJob(scanner.nextLine());

        System.out.println("Введите номер менеджера:");
        employee.setMgr(Integer.parseInt(scanner.nextLine()));

        System.out.println("Введите дату приема на работу (dd MM yyyy):");
        String hiredate = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
        employee.setHiredate(LocalDate.parse(hiredate, dtf));

        System.out.println("Введите размер оклад:");
        employee.setSal(Float.parseFloat(scanner.nextLine()));

        System.out.println("Введите размер комиссионных:");
        employee.setComm(Float.parseFloat(scanner.nextLine()));

        System.out.println("Введите номер подразделения:");
        employee.setDepno(Integer.parseInt(scanner.nextLine()));

        return employee;
    }

    public void printResult(String checkAddEmployee) {
        System.out.println("Сотрудник " + checkAddEmployee);
    }
}
