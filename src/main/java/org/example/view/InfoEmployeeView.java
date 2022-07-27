package org.example.view;

import java.util.Scanner;

public class InfoEmployeeView implements View{

    private static final Scanner scanner = new Scanner(System.in);

    public int readEmpnoEmployee(){
        System.out.print("Введите номер сотрудника: ");
        int empno = scanner.nextInt();

        return empno;
    }

    public void printResult(String infoEmployee) {
        System.out.println(infoEmployee);
    }


}
