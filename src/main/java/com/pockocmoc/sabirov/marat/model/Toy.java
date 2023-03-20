package com.pockocmoc.sabirov.marat.model;

import java.util.List;

public class Toy {
    private int id;
    private String name;
    private int amount;
    private int dropFrequency;

    public Toy(int id, String name, int amount, int dropFrequency) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.dropFrequency = dropFrequency;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDropFrequency() {
        return dropFrequency;
    }

    public void setDropFrequency(int dropFrequency) {
        this.dropFrequency = dropFrequency;
    }

    @Override
    public String toString() {
        return "\nИгрушка " +
                "№ " + id +
                ", '" + name + '\'' +
                ", количество: " + amount +
                ", шанс выпадения: " + dropFrequency + " %";
    }
}
