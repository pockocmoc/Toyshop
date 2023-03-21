package com.pockocmoc.sabirov.marat.view;

import com.pockocmoc.sabirov.marat.controller.BuyerCSVHandler;
import com.pockocmoc.sabirov.marat.controller.ToyCSVHandler;

public class Run {
    final String FILE_NAME_TOYS = "./src/main/java/com/pockocmoc/sabirov/marat/db/toys.csv";
    final String FILE_NAME_BUYERS = "./src/main/java/com/pockocmoc/sabirov/marat/db/buyers.csv";

    public void run() {
        int numberOfMenu;
        do {
            ViewMenu.pageHeadMenuView();
            numberOfMenu = InputNumberValidator.choice();
            switch (numberOfMenu) {
                case 1:
                    runToys();
                    break;
                case 2:
                    runBuyers();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        } while (numberOfMenu != 4);
    }


    public void runToys() {
        int numberOfMenu;
        do {
            ViewMenu.pageToyView();
            numberOfMenu = InputNumberValidator.choice();
            switch (numberOfMenu) {
                case 1:
                    System.out.println(ToyCSVHandler.readFromFile(FILE_NAME_TOYS));
                    break;
                case 2:
                    ToyCSVHandler.addNewToy();
                    break;
                case 3:
                    System.out.println(ToyCSVHandler.readFromFile(FILE_NAME_TOYS));
                    System.out.println("Введите № игрушки для изменения веса игрушки: ");
                    int idToy = InputNumberValidator.choice();
                    System.out.println("Введите новый вес игрушки: ");
                    int changeWeight = InputNumberValidator.choice();
                    ToyCSVHandler.updateToyDropFrequencyById(FILE_NAME_TOYS, idToy
                            , changeWeight);
                    System.out.println("Вес изменен!");
                    break;
                case 4:
                    System.out.println(ToyCSVHandler.readFromFile(FILE_NAME_TOYS));
                    System.out.println("Введите № игрушки для удаления: ");
                    ToyCSVHandler.removeToy(FILE_NAME_TOYS, InputNumberValidator.choice());
                    System.out.println("Игрушка удалена!");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Некорректный ввод.");
            }
        } while (numberOfMenu != 5);
    }

    public void runBuyers() {
        int numberOfMenu;
        do {
            ViewMenu.pageBuyersView();
            numberOfMenu = InputNumberValidator.choice();
            switch (numberOfMenu) {
                case 1:
                    System.out.println(BuyerCSVHandler.readFromFile(FILE_NAME_BUYERS));
                    break;
                case 2:
                    BuyerCSVHandler.addNewBuyer();
                    System.out.println("Новый покупатель добавлен!");
                    break;
                case 3:

                    break;
                case 4:
                    break;
                default:
                    System.out.println("Некорректный ввод.");
            }
        } while (numberOfMenu != 4);
    }
}