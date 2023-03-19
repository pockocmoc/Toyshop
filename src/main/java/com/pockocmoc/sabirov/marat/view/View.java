package com.pockocmoc.sabirov.marat.view;

import com.pockocmoc.sabirov.marat.controller.ToyCSVHandler;
import com.pockocmoc.sabirov.marat.controller.ToyHandler;

import java.util.Scanner;

public class View {
    final String FILE_NAME_TOYS = "./src/main/java/com/pockocmoc/sabirov/marat/db/toys.csv";
    final String FILE_NAME_BUYERS = "./src/main/java/com/pockocmoc/sabirov/marat/db/buyers.csv";

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int numberOfMenu;
        do {
            System.out.println("\t\tМеню магазина игрушек.");
            System.out.println("*".repeat(40));
            System.out.println("1. Посмотреть все игрушки.");
            System.out.println("2. Добавить игрушку.");
            System.out.println("3. Изменить вес игрушки.");
            System.out.println("4. Выход из программы.");
            numberOfMenu = scanner.nextInt();

            switch (numberOfMenu) {
                case 1:
                    System.out.println(ToyCSVHandler.readFromFile(FILE_NAME_TOYS));
                    break;
                case 2:
                    // Добавление новой игрушки
                    ToyHandler toyHandler = new ToyHandler();
                    toyHandler.addNewToy();
                    break;
                case 3:
                    // Изменение веса игрушки
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        } while (numberOfMenu != 4);
    }
}