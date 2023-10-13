package com.example.groupexpenseitemsbydate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {
    private static final int TYPE_DATE_HEADER = 0;
    private static final int TYPE_EXPENSE = 1;
    private Context context;
    private List<Expense> data;
    private int resourceId;
    private final LayoutInflater mInflater;
    public ExpenseAdapter(Context context, List<Expense> data, int resourceId){
        this.context = context;
        this.data= data;
        this.resourceId = resourceId;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        if(viewType == TYPE_DATE_HEADER){
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_header, parent, false);
//            return new DateHeaderViewHolder(view);
//        } else
//        if (viewType == TYPE_EXPENSE) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_item, parent, false);
        return new ExpenseViewHolder(view);
//        }
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        Expense expense = data.get(position);
        holder.update(expense);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ExpenseViewHolder extends RecyclerView.ViewHolder {
        public TextView txtDate, txtAmount, txtDes;
        Expense expense;
        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDate = itemView.findViewById(R.id.text_date);
            txtAmount = itemView.findViewById(R.id.text_amount);
            txtDes = itemView.findViewById(R.id.text_description);
        }

        public void update(Expense expense){
            this.expense = expense;
            txtDate.setText(expense.getDateString());
            txtAmount.setText(String.valueOf(expense.getAmount()));
            txtDes.setText(expense.getCategory());

        }
    }
}
