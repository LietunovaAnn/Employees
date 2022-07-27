package org.example.view;

import java.util.Scanner;

public class UserScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static int checkChoosingRightNumber(int first, int last) {
//        while (!(scanner.hasNextInt())) {
//            System.out.print("Your input is incorrect! Enter number: ");
//            scanner.nextLine();
//        }
        int enter = scanner.nextInt();
        if (enter < first || enter > last) {
            System.out.println("Incorrect format. Please, enter the correct number.");
            enter = checkChoosingRightNumber(first, last);
        }
        return enter;
    }
}