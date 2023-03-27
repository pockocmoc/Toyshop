package com.pockocmoc.sabirov.marat.controller;

import com.pockocmoc.sabirov.marat.model.AwardedPrize;
import com.pockocmoc.sabirov.marat.model.Prize;
import com.pockocmoc.sabirov.marat.model.Toy;
import com.pockocmoc.sabirov.marat.view.InputNumberValidator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static com.pockocmoc.sabirov.marat.controller.BuyerCSVHandler.startId;

public class ToyCSVHandler {
    static final String CSV_SEPARATOR = ",";
    private static final String FILE_NAME_TOYS = "./src/main/java/com/pockocmoc/sabirov/marat/db/toys.csv";
    static final String PRIZE_TOY = "./src/main/java/com/pockocmoc/sabirov/marat/db/PrizeToyList.csv";
    final String AWARDED_TOY = "./src/main/java/com/pockocmoc/sabirov/marat/db/AwardedToyFromByuers.csv";
    static List<Toy> toys = new ArrayList<>();

    static List<Prize> prizes = new ArrayList<>();
    static List<AwardedPrize> awardedPrizes = new ArrayList<>();


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

            }
            if (!idFound) {
                System.out.println("Ошибка, нет игрушки с таким номером!");
            }

            overwriteFile(fileName, toys);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateToyAmountById(String fileName, int id, int amounts) {
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
//                    System.out.println("Введите новый вес игрушки: ");
//                    changeWeight = InputNumberValidator.choice();
                    toys.add(new Toy(toyId, name, amounts, dropFrequency));
//                    System.out.println("Вес игрушки изменён!");
                    idFound = true;
                } else {
                    toys.add(new Toy(toyId, name, amount, dropFrequency));
                }

            }
            if (!idFound) {
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

    public static void writeToPrizeToys(String fileName, List<Prize> prizes) {
        try (FileWriter writer = new FileWriter(fileName, true)) {

            appendToPrize(prizes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void appendToPrize(List<Prize> prizes, FileWriter writer) throws IOException {
        for (Prize prize : prizes) {
            writer.append(String.valueOf(prize.getId()));
            writer.append(CSV_SEPARATOR);
            writer.append(prize.getName());
            writer.append(CSV_SEPARATOR);
            writer.append(String.valueOf(prize.getAmount()));
            writer.append(CSV_SEPARATOR);
            writer.append(String.valueOf(prize.getDropFrequency()));
            writer.append("\n");
        }

        writer.flush();
    }


    public static void chooseRandomToyAndSaveToFile(String fileTwo) {
        if (toys.isEmpty()) {
            return;
        }
        Random random = new Random();
        int index = random.nextInt(toys.size());
        Toy chosenToy = toys.get(index);
        Prize prizeToy = new Prize(
                chosenToy.getId(),
                chosenToy.getName(),
                chosenToy.getAmount(),
                chosenToy.getDropFrequency());
        prizes.add(prizeToy);
        toys.remove(chosenToy);
//        chosenToy.setAmount(chosenToy.getAmount() - 1);
//        ToyCSVHandler.updateToyAmountById(fileName, chosenToy.getId(), chosenToy.getAmount());
//        ToyCSVHandler.removeToy(FILE_NAME_TOYS, chosenToy.getId());
//        if (chosenToy.getAmount() == 0) {
//            toys.remove(chosenToy);
//            ToyCSVHandler.removeToy(fileName, chosenToy.getId());
//        }
        ToyCSVHandler.writeToPrizeToys(fileTwo, prizes);
    }

    public static void chooseAwardedPrizeRandom(String fileName, String fileTwo) {
        if (prizes.isEmpty()) {
            return;
        }
        Random random = new Random();
        int index = random.nextInt(prizes.size());
        Prize chosenPrize = prizes.get(index);
        AwardedPrize awardedPrize = new AwardedPrize(
                chosenPrize.getId(),
                chosenPrize.getName());
        awardedPrizes.add(awardedPrize);
        chosenPrize.setAmount(chosenPrize.getAmount() + 1);
        if (chosenPrize.getAmount() == 0) {
            toys.remove(chosenPrize);
            ToyCSVHandler.removePrizeToy(fileName, index);
        }
        ToyCSVHandler.writeToAwardedPrizeToys(fileTwo, awardedPrizes);


    }

    public static void writeToAwardedPrizeToys(String fileName, List<AwardedPrize> awardedPrizes) {
        try (FileWriter writer = new FileWriter(fileName, true)) {

            appendToAwardedPrize(awardedPrizes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void appendToAwardedPrize(List<AwardedPrize> awardedPrizes, FileWriter writer) throws IOException {
        for (Prize prize : awardedPrizes) {
            writer.append(String.valueOf(prize.getId()));
            writer.append(CSV_SEPARATOR);
            writer.append(prize.getName());
            writer.append(CSV_SEPARATOR);
            writer.append(String.valueOf(prize.getAmount()));
            writer.append(CSV_SEPARATOR);
            writer.append(String.valueOf(prize.getDropFrequency()));
            writer.append("\n");
        }

        writer.flush();
    }

    public static void removePrizeToy(String fileName, int id) {
        List<Prize> prizes = readPrizeFile(fileName);
        boolean isToyFound = false;
        for (Prize prize : prizes) {
            if (prize.getId() == id) {
                prizes.remove(prize);
                System.out.println("Игрушка удалена!");
                isToyFound = true;
                break;
            }
        }
        if (!isToyFound) {
            System.out.println("Нет игрушки с таким номером!");
        }

        overwritePrizeFile(fileName, prizes);
    }


    public static void overwritePrizeFile(String fileName, List<Prize> prizes) {
        try (FileWriter writer = new FileWriter(fileName)) {

            appendToPrize(prizes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Prize> readPrizeFile(String fileName) {
        List<Prize> prizes = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {

                String[] fields = line.split(CSV_SEPARATOR);

                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                int amount = Integer.parseInt(fields[2]);
                int dropFrequency = Integer.parseInt(fields[3]);


                Prize prize = new Prize(id, name, amount, dropFrequency);
                prizes.add(prize);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prizes;
    }
}