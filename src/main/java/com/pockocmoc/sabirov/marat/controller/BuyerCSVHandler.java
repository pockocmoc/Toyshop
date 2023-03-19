package com.pockocmoc.sabirov.marat.controller;

import com.pockocmoc.sabirov.marat.model.Buyer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuyerCSVHandler {
    private static final String DELIMITER = ",";
    private static final String FILE_HEADER = "id,name,surname,check number, phone";


    public void writeToFile(String fileName, List<Buyer> buyers) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append(FILE_HEADER);
            writer.append("\n");
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

    public List<Buyer> readFromFile(String fileName) {
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