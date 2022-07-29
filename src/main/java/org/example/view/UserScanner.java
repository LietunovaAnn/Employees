package org.example.view;

import java.util.Scanner;

public class UserScanner {
    private static final Scanner scanner = new Scanner(System.in);

    private static int readUserChoiceNumber(int first, int last) throws NumberFormatException {
        int enter = Integer.parseInt(scanner.nextLine());
        if (enter < first || enter > last) {
            System.out.println("Неправильный формат. Пожалуйста, введите правильный номер.");
            enter = checkChoosingRightNumber(first, last);
        }
        return enter;
    }
    public static int checkChoosingRightNumber(int first, int last) {
        int value;
        try {
            value = readUserChoiceNumber(first, last);
        } catch (NumberFormatException e) {
            System.out.println("Неправильный формат. Пожалуйста, введите правильный номер.");
            value = checkChoosingRightNumber(first, last);
        }
        return value;
    }
}