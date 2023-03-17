package com.pockocmoc.sabirov.marat.model;

import java.util.ArrayList;

public class Drawing {
ArrayList<Prize> prizes;
ArrayList<AwardedPrize> awardedPrizes;

    public Drawing(ArrayList<Prize> prizes, ArrayList<AwardedPrize> awardedPrizes) {
        this.prizes = prizes;
        this.awardedPrizes = awardedPrizes;
    }

    public ArrayList<Prize> getPrizes() {
        return prizes;
    }

    public void setPrizes(ArrayList<Prize> prizes) {
        this.prizes = prizes;
    }

    public ArrayList<AwardedPrize> getAwardedPrizes() {
        return awardedPrizes;
    }

    public void setAwardedPrizes(ArrayList<AwardedPrize> awardedPrizes) {
        this.awardedPrizes = awardedPrizes;
    }
}
