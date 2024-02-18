package com.dorontayar.recycleviewpijamot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    private Context context;
    private ArrayList<CharacterModel> dataSet;
    private SelectListener listener;


    public CharacterAdapter(Context context, ArrayList<CharacterModel> dataSet, SelectListener listener) {
        this.context = context;
        this.dataSet = dataSet;
        this.listener=listener;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inflate the card here, where the data is
        return new CharacterViewHolder(LayoutInflater.from(context).inflate(R.layout.single_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //Here where we use to put the data in the card
            holder.textName.setText(dataSet.get(position).getName());
            holder.imageActor.setImageResource(dataSet.get(position).getImage());
            holder.textDescription.setText(dataSet.get(position).getDescription());

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicker(dataSet.get(position));
                }
            });
    }

    @Override
    public int getItemCount() {
        //Returns how many items in our recycle view
        return dataSet.size();
    }
    public void filterList(ArrayList<CharacterModel> filteredList){
        dataSet =  filteredList;
        notifyDataSetChanged();

    }
}
