package co.donebyme.matching.model.proposal;

import java.util.Calendar;

public class Expectations {

    private String summary, description;

    private double price;

    private Calendar date;

    private Expectations(String summary, String description, double price, Calendar date) {
        this.summary = summary;
        this.description = description;
        this.price = price;
        this.date = date;
    }

    public static Expectations of(String summary, String description, double price, Calendar date){
        return new Expectations(summary, description, price, date);
    }




}
