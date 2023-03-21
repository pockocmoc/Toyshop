package com.pockocmoc.sabirov.marat.view;

import com.pockocmoc.sabirov.marat.controller.ToyCSVHandler;
import com.pockocmoc.sabirov.marat.controller.ToyHandler;

public class Run {
    final String FILE_NAME_TOYS = "./src/main/java/com/pockocmoc/sabirov/marat/db/toys.csv";
    final String FILE_NAME_BUYERS = "./src/main/java/com/pockocmoc/sabirov/marat/db/buyers.csv";

    public void run() {
        int numberOfMenu;
        do {
            ViewMenu.pageHeadMenuView();
            numberOfMenu = ChoiceConsoleNumber.choice();
            switch (numberOfMenu) {
                case 1:
                    runToys();
                    break;
                case 2:
                    ViewMenu.pageBuyersView();
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
            numberOfMenu = ChoiceConsoleNumber.choice();
            switch (numberOfMenu) {
                case 1:
                    System.out.println(ToyCSVHandler.readFromFile(FILE_NAME_TOYS));
                    break;
                case 2:
                    ToyHandler.addNewToy();
                    break;
                case 3:
                    System.out.println(ToyCSVHandler.readFromFile(FILE_NAME_TOYS));
                    System.out.println("Введите № игрушки для изменения веса игрушки: ");
                    ToyCSVHandler.updateToyDropFrequencyById(FILE_NAME_TOYS, ChoiceConsoleNumber.choice()
                            , ChoiceConsoleNumber.choice());
                    break;
                case 4:
                    System.out.println(ToyCSVHandler.readFromFile(FILE_NAME_TOYS));
                    System.out.println("Введите № игрушки для удаления: ");
                    ToyCSVHandler.removeToy(FILE_NAME_TOYS, ChoiceConsoleNumber.choice());
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Некорректный ввод.");
            }
        } while (numberOfMenu != 5);
    }
}