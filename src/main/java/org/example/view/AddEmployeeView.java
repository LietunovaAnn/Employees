package org.example.view;


import org.example.model.entities.Employee;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AddEmployeeView implements View {
    private static final Scanner scanner = new Scanner(System.in);

    public Employee readNewEmployee() {
        Employee employee = new Employee();
        try {
            readEmpnoEmployee(employee);
            readEnameEmployee(employee);
            readJobEmployee(employee);
            readMgrEmployee(employee);
            readHiredateEmployee(employee);
            readSalEmployee(employee);
            readCommEmployee(employee);
            readDepnoEmployee(employee);
        } catch (Exception e) {
            System.out.println("Неправильный формат. Попробуйте еще раз.");
            employee = readNewEmployee();
        }
        return employee;
    }
    private void readEmpnoEmployee(Employee employee) throws Exception{
        System.out.println("Введите номер сотрудника:");
        employee.setEmpno(Integer.parseInt(scanner.nextLine()));
    }
    private void readEnameEmployee(Employee employee) throws Exception{
        System.out.println("Введите имя:");
        employee.setEname(scanner.nextLine());
    }
    private void readJobEmployee(Employee employee) throws Exception{
        System.out.println("Введите должность:");
        employee.setJob(scanner.nextLine());

    }
    private void readMgrEmployee(Employee employee) throws Exception{
        System.out.println("Введите номер менеджера:");
        employee.setMgr(Integer.parseInt(scanner.nextLine()));
    }
    private void readHiredateEmployee(Employee employee) throws Exception{
        System.out.println("Введите дату приема на работу (dd MM yyyy):");
        String hiredate = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
        employee.setHiredate(LocalDate.parse(hiredate, dtf));
    }

    private void readSalEmployee(Employee employee) throws Exception{
        System.out.println("Введите размер оклад:");
        employee.setSal(Float.parseFloat(scanner.nextLine()));
    }
    private void readCommEmployee(Employee employee) throws Exception{
        System.out.println("Введите размер комиссионных:");
        employee.setComm(Float.parseFloat(scanner.nextLine()));
    }
    private void readDepnoEmployee(Employee employee) throws Exception{
        System.out.println("Введите номер подразделения:");
        employee.setDepno(Integer.parseInt(scanner.nextLine()));
    }


    public void printResult(String checkAddEmployee) {
        System.out.println("Сотрудник " + checkAddEmployee);
    }
}
