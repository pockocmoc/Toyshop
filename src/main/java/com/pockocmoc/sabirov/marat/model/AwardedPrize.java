package com.pockocmoc.sabirov.marat.model;

import java.time.LocalDateTime;
import java.util.Locale;

public class AwardedPrize extends Prize{
    private LocalDateTime dateTimeAwarded;

    public AwardedPrize(int id, Buyer buyer, Toy toy, LocalDateTime dateTimeAwarded) {
        super(id, buyer, toy);
        this.dateTimeAwarded = dateTimeAwarded;
    }
}
