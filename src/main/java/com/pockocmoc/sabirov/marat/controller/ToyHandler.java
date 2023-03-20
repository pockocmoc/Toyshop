package com.pockocmoc.sabirov.marat.controller;

import com.pockocmoc.sabirov.marat.model.Toy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ToyHandler {
    private static final String FILE_NAME_TOYS = "./src/main/java/com/pockocmoc/sabirov/marat/db/toys.csv";
    static List<Toy> toys = new ArrayList<>();

    public static void addNewToy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter toy name:");
        String name = scanner.nextLine();
        System.out.println("Enter amount of toys:");
        int amount = scanner.nextInt();
        System.out.println("Enter drop frequency of toys:");
        int dropFrequency = scanner.nextInt();
        toys.add(new Toy(getNewToyId(), name, amount, dropFrequency));
        ToyCSVHandler.writeToFile(FILE_NAME_TOYS, toys);
    }

    private static int getNewToyId() {
        int count = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME_TOYS));

            while (reader.readLine() != null) count++;
            System.out.println("Количество строк в файле: " + count);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } return count;
    }
}