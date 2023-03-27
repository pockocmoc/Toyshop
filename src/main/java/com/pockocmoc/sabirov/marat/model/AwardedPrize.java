package com.pockocmoc.sabirov.marat.model;

public class AwardedPrize extends Prize{


    public AwardedPrize(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Номер " + getId() + " Название " + getName();
    }
}
