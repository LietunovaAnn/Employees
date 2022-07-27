package org.example.view;


import org.example.controller.Controller;

import java.util.Scanner;

public class RemoveEmployeeView implements View {

    private static final Scanner scanner = new Scanner(System.in);


    public int printInfo() {
        System.out.println("Введите номер сотрудника, который будет удален: ");
        int empno = Integer.parseInt(scanner.nextLine());

        return empno;
    }


    public void printResult(String s) {
        System.out.println(s);
    }
}
