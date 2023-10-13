package com.example.groupexpenseitemsbydate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Expense> Expenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.Recycler_view);

        List<Expense> expense = loadExpense();

        ExpenseAdapter adapter = new ExpenseAdapter(this, expense, R.layout.expense_item);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

    }

    private ArrayList<Expense> getExpensesByDate(List<Expense> expenses, LocalDate date){
        ArrayList<Expense> filtered = new ArrayList<>();
        for(Expense expense: expenses){

            if(expense.getDate().equals(date)){
                filtered.add(expense);
            }
        }
        return filtered;
    }
    private ArrayList<ArrayList<Expense>>
        getExpenseByMonth(List<Expense> expenses, int month, int year) {

        ArrayList<ArrayList<Expense>> expenseByDay = new ArrayList<>();

        // Get number of days in that month
        int daysInMonth = YearMonth.of(year, month).lengthOfMonth(); // Uses Java 8 API

        // Loop through each day
        for(int day=1; day <= daysInMonth; day++) {
            // Get expenses for this day
            ArrayList<Expense> expensesForDay = getExpensesByDate(expenses, LocalDate.of(year, month, day));

            // Add to result
            expenseByDay.add(expensesForDay);
        }

        return expenseByDay;
    }
    private List<Date> getDates(List<Expense> expenses){
        List<Date> dates = new ArrayList<>();
        for(Expense expense: expenses){
            Date date = expense.getDate();

            if(!dates.contains(date)){
                dates.add(date);
            }
        }
        return dates;
    }
    private List<Expense> loadExpense() {
        List<Expense> expenses = new ArrayList<>();

        expenses.add(
            new Expense(
                new Date(), "cate", 10));
        expenses.add(
                new Expense(
                    new Date(), "ass", 10));
        expenses.add(
                new Expense(
                    new Date(), "cte", 10));

        return expenses;
    }


}