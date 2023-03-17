package com.pockocmoc.sabirov.marat;

import com.pockocmoc.sabirov.marat.controller.DataBase;
import com.pockocmoc.sabirov.marat.model.Toy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Toy toy = new Toy(1, "Кубик рубик", 400, 10);
        System.out.println(toy);

        String fileName = "toys.csv";
        FileWriter fileWriter = new FileWriter(fileName);


        fileWriter.append(String.valueOf(toy));
        fileWriter.flush();
    }
}
