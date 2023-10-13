package com.example.groupexpenseitemsbydate;

import java.util.Date;

public class DateHeaderItem {
    private Date date;
    public DateHeaderItem(Date date){
        this.date = date;
    }
    public Date getDate(){
        return date;
    }
}
