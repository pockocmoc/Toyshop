package com.pockocmoc.sabirov.marat.controller;

import com.pockocmoc.sabirov.marat.model.Toy;

import java.util.List;
import java.util.Scanner;


public class ToyHandler {
    private static final String FILE_NAME_TOYS = "./src/main/java/com/pockocmoc/sabirov/marat/db/toys.csv";;

    public void addNewToy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID новой игрушки:");
        int id = scanner.nextInt();
        System.out.println("Введите название новой игрушки:");
        String name = scanner.next();
        System.out.println("Введите количество новой игрушки:");
        int amount = scanner.nextInt();
        System.out.println("Введите частоту выпадения новой игрушки:");
        int dropFrequency = scanner.nextInt();
        Toy  = new Toy(id, name, amount, dropFrequency);
        // здесь можно добавить новую игрушку в какой-то список или базу данных
//        ToyCSVHandler toyCSVHandler = new ToyCSVHandler();
        ToyCSVHandler.writeToFile(FILE_NAME_TOYS, toys);
    }
}