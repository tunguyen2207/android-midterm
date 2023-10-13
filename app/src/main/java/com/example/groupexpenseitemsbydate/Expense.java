package com.example.groupexpenseitemsbydate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Expense {
    private Date date;
    private String category;
    private int amount;
    private String description;
    SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
    public Expense(Date date, String category, int amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        description ="des";
    }

    public Date getDate(){
        return this.date;
    }
    public String getDateString(){
        return fm.format(this.date);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
