package com.example.m3_lesson4_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private ArrayList<Country> countries;
    private OnItemClick onItemClick;

    public CountryAdapter(ArrayList<Country> countries, OnItemClick onItemClick) {
        this.countries = countries;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CountryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.bind(countries.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onItemClick(countries.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }



    static class CountryViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvCapitalName;
        private ImageView flag;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvCapitalName = itemView.findViewById(R.id.tv_capital_name);
            flag = itemView.findViewById(R.id.flag);
        }

        public void bind(Country country) {
            tvName.setText(country.getName());
            tvCapitalName.setText(country.getCapitalName());
            Glide.with(flag).load(country.getFlag()).into(flag);

        }
    }
}
