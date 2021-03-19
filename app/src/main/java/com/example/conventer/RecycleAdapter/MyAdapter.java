package com.example.conventer.RecycleAdapter;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.conventer.R;
import com.example.conventer.pojo.DailyCurrency;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final ArrayList<DailyCurrency> listItems = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.bind(listItems.get(position));
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public void setItems(List<DailyCurrency> currencies) {
        listItems.addAll(currencies);
        notifyDataSetChanged();
    }

    @SuppressLint("NonConstantResourceId")


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView charCode;
        public TextView name;
        public TextView nominal;
        public TextView values;


        public ViewHolder(View itemView) {
            super(itemView);
            charCode = itemView.findViewById(R.id.charCode);
            name = itemView.findViewById(R.id.name);
            nominal = itemView.findViewById(R.id.nominal);
            values = itemView.findViewById(R.id.values);
        }

        @SuppressLint("SetTextI18n")
        public void bind(DailyCurrency dailyCurrency) {
            charCode.setText(dailyCurrency.getCharCode());
            name.setText(dailyCurrency.getName());
            nominal.setText("Номинал: " + dailyCurrency.getNominal());
            values.setText(String.valueOf(dailyCurrency.getValue()));
        }
    }
}
