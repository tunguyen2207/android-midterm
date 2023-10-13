package com.example.groupexpenseitemsbydate;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;

public class DateHeaderHolder extends RecyclerView.ViewHolder {
    private View textViewDate;
    public DateHeaderHolder(@NonNull View itemView) {
        super(itemView);
        textViewDate = itemView.findViewById(R.id.text_date);
    }
    public void bind(DateHeaderItem dateHeaderItem){
        textViewDate.setTextDirection(formatDate(dateHeaderItem.getDate()));
    }

    private int formatDate(Date date) {
        return 0;
    }
}
