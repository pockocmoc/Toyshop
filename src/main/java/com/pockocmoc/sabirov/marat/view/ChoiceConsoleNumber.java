package com.pockocmoc.sabirov.marat.view;

import java.util.Scanner;

public class ChoiceConsoleNumber {
    public static int choice() {
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            try {
                num = Integer.parseInt(scanner.nextLine());
                if (num < 1) {
                    System.out.println("Ошибка: число должно быть больше 0");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число");
            }
        }
        return num;
    }
}