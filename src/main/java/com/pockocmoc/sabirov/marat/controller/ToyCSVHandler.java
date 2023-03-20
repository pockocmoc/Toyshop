package com.pockocmoc.sabirov.marat.controller;

import com.pockocmoc.sabirov.marat.model.Toy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ToyCSVHandler {
    private static final String CSV_SEPARATOR = ",";
    private static final String FILE_HEADER = "id,name,amount,dropFrequency";


    public static void writeToFile(String fileName, List<Toy> toys) {
        try (FileWriter writer = new FileWriter(fileName, true)) {

            for (Toy toy : toys) {
                writer.append(String.valueOf(toy.getId()));
                writer.append(CSV_SEPARATOR);
                writer.append(toy.getName());
                writer.append(CSV_SEPARATOR);
                writer.append(String.valueOf(toy.getAmount()));
                writer.append(CSV_SEPARATOR);
                writer.append(String.valueOf(toy.getDropFrequency()));
                writer.append("\n");
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Toy> readFromFile(String fileName) {
        List<Toy> toys = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] fields = line.split(CSV_SEPARATOR);

                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                int amount = Integer.parseInt(fields[2]);
                int dropFrequency = Integer.parseInt(fields[3]);

                Toy toy = new Toy(id, name, amount, dropFrequency);
                toys.add(toy);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toys;
    }
}