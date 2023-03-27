package com.pockocmoc.sabirov.marat.model;

import java.time.LocalDateTime;

public class AwardedPrize extends Prize{
    private LocalDateTime dateTimeAwarded;


    public AwardedPrize(int id, String name) {
        super(id, name);
        this.dateTimeAwarded = dateTimeAwarded;
    }

    public LocalDateTime getDateTimeAwarded() {
        return dateTimeAwarded;
    }

    public void setDateTimeAwarded(LocalDateTime dateTimeAwarded) {
        this.dateTimeAwarded = dateTimeAwarded;
    }

    @Override
    public String toString() {
        return "AwardedPrize{" +
                "dateTimeAwarded=" + dateTimeAwarded +
                '}';
    }
}
