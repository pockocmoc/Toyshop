package com.pockocmoc.sabirov.marat.controller;

import com.pockocmoc.sabirov.marat.model.Buyer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuyerCSVHandler {
    private static final String DELIMITER = ",";
    private static final String FILE_NAME_BUYERS = "./src/main/java/com/pockocmoc/sabirov/marat/db/buyers.csv";
    static List<Buyer> buyers = new ArrayList<>();


    public static void addNewBuyer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя покупателя: ");
        String nameBuyer = scanner.nextLine();
        System.out.println("Введите фамилию покупателя: ");
        String surnameBuyer = scanner.nextLine();
        System.out.println("Введите номера чека: ");
        int check = scanner.nextInt();
        System.out.println("Введите номера телефона: ");
        int phoneNumber = scanner.nextInt();
        buyers.add(new Buyer(getBuyerId(), nameBuyer, surnameBuyer, check, phoneNumber));
        BuyerCSVHandler.writeToBuyersFile(FILE_NAME_BUYERS, buyers);
    }
    private static int getBuyerId() {
        int maxId = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME_BUYERS));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0].replaceAll("\"", ""));
                if (id > maxId) {
                    maxId = id;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maxId + 1;
    }
    public static void writeToBuyersFile(String fileName, List<Buyer> buyers) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            for (Buyer buyer : buyers) {
                writer.append(String.valueOf(buyer.getId()));
                writer.append(DELIMITER);
                writer.append(buyer.getName());
                writer.append(DELIMITER);
                writer.append(buyer.getSurname());
                writer.append(DELIMITER);
                writer.append(String.valueOf(buyer.getCheckNumber()));
                writer.append(DELIMITER);
                writer.append(String.valueOf(buyer.getPhoneNumber()));
                writer.append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static List<Buyer> readFromFile(String fileName) {
        List<Buyer> buyers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(DELIMITER);
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String surname = fields[2];
                int checkNumber = Integer.parseInt(fields[3]);
                int phoneNumber = Integer.parseInt(fields[4]);
                buyers.add(new Buyer(id, name, surname, checkNumber, phoneNumber));
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return buyers;
    }
}