package com.pockocmoc.sabirov.marat.view;
import com.pockocmoc.sabirov.marat.controller.ToyCSVHandler;
import com.pockocmoc.sabirov.marat.controller.ToyHandler;

public class View {
    final String FILE_NAME_TOYS = "./src/main/java/com/pockocmoc/sabirov/marat/db/toys.csv";
    final String FILE_NAME_BUYERS = "./src/main/java/com/pockocmoc/sabirov/marat/db/buyers.csv";

    ChoiceConsoleNumber choice = new ChoiceConsoleNumber();
    public void run() {
        int numberOfMenu = 0;
        do {
            Menu.pageToyView();
            numberOfMenu = choice.choice();
            switch (numberOfMenu) {
                case 1:
                    System.out.println(ToyCSVHandler.readFromFile(FILE_NAME_TOYS));
                    break;
                case 2:
                    // Добавление новой игрушки
                    ToyHandler.addNewToy();
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