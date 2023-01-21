package com.example.example;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.example.databinding.ItemContinentBinding;

import java.io.Serializable;
import java.util.ArrayList;

public class AdapterContinent extends RecyclerView.Adapter<ContinentViewHolder> implements Serializable {

    private ArrayList<ContinentModel> nameList;
    private OnItemClick onItemClick;
    ContinentModel continentModel;


    public AdapterContinent(ArrayList<ContinentModel> nameList, OnItemClick onItemClick) {
        this.nameList = nameList;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentViewHolder(ItemContinentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.onBind(nameList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onClick(nameList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }
}

class ContinentViewHolder extends RecyclerView.ViewHolder {
    ItemContinentBinding binding;

    public ContinentViewHolder(@NonNull ItemContinentBinding itemContinentBinding) {
        super(itemContinentBinding.getRoot());
        this.binding = itemContinentBinding;

    }

    void onBind(ContinentModel conteinerModel) {
        binding.imgContinent.setImageResource(conteinerModel.getAvatarImageCountry());
        binding.textView.setText(conteinerModel.getName());
    }
}


