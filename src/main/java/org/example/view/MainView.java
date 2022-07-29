package org.example.view;

import java.util.Scanner;

public class MainView implements View{
    private static final Scanner scanner = new Scanner(System.in);


    public int chooseAction() {
        System.out.println("Активность");
        System.out.println("1. Посмотреть информацию сотрудника.");
        System.out.println("2. Добавить нового сотрудника.");
        System.out.println("3. Удалить сотрудника.");
        System.out.println("4. Выйти.");
        int number = UserScanner.checkChoosingRightNumber(1,4);
        return number;
    }



}
