package com.pockocmoc.sabirov.marat.controller;

import com.pockocmoc.sabirov.marat.model.Toy;
import com.pockocmoc.sabirov.marat.view.InputNumberValidator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.pockocmoc.sabirov.marat.controller.BuyerCSVHandler.startId;

public class ToyCSVHandler {
    static final String CSV_SEPARATOR = ",";
    private static final String FILE_NAME_TOYS = "./src/main/java/com/pockocmoc/sabirov/marat/db/toys.csv";
    static List<Toy> toys = new ArrayList<>();
//    private static final String FILE_HEADER = "id,name,amount,dropFrequency";


    public static void writeToFile(String fileName, List<Toy> toys) {
        try (FileWriter writer = new FileWriter(fileName, true)) {

            appendToFileLine(toys, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addNewToy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя игрушки: ");
        String name = scanner.nextLine();
        System.out.println("Введите количество игрушек: ");
        int amount = scanner.nextInt();
        System.out.println("Введите вес игрушки(шанс выпадения): ");
        int dropFrequency = scanner.nextInt();
        toys.add(new Toy(getNewToyId(), name, amount, dropFrequency));
        ToyCSVHandler.writeToFile(FILE_NAME_TOYS, toys);
    }

    private static int getNewToyId() {
        return startId(FILE_NAME_TOYS);
    }

    private static void appendToFileLine(List<Toy> toys, FileWriter writer) throws IOException {
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
    }

    public static void updateToyDropFrequencyById(String fileName, int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            List<Toy> toys = new ArrayList<>();
            String line;

            boolean idFound = false;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(CSV_SEPARATOR);
                int toyId = Integer.parseInt(fields[0]);
                String name = fields[1];
                int amount = Integer.parseInt(fields[2]);
                int dropFrequency = Integer.parseInt(fields[3]);
                int changeWeight;
                if (toyId == id) {
                    System.out.println("Введите новый вес игрушки: ");
                    changeWeight = InputNumberValidator.choice();
                    toys.add(new Toy(toyId, name, amount, changeWeight));
                    System.out.println("Вес игрушки изменён!");
                    idFound = true;
                } else {
                    toys.add(new Toy(toyId, name, amount, dropFrequency));
                }

            }if (!idFound) {
                System.out.println("Ошибка, нет игрушки с таким номером!");
            }

            overwriteFile(fileName, toys);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Toy> readFromFile(String fileName) {
        List<Toy> toys = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {

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

    public static void removeToy(String fileName, int id) {
        List<Toy> toys = readFromFile(fileName);
        boolean isToyFound = false;
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toys.remove(toy);
                System.out.println("Игрушка удалена!");
                isToyFound = true;
                break;
            }
        }
        if (!isToyFound) {
            System.out.println("Нет игрушки с таким номером!");
        }

        overwriteFile(fileName, toys);
    }

    public static void overwriteFile(String fileName, List<Toy> toys) {
        try (FileWriter writer = new FileWriter(fileName)) {

            appendToFileLine(toys, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}