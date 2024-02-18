package com.dorontayar.recycleviewpijamot;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class CharacterViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageActor;
    public TextView textName;
    public TextView textDescription;
    public CardView cardView;

    public CharacterViewHolder(@NonNull View itemView) {
        super(itemView);
        textName = itemView.findViewById(R.id.textViewName);
        imageActor = itemView.findViewById(R.id.imageViewActor);
        textDescription = itemView.findViewById(R.id.textViewDescription);
        cardView = itemView.findViewById(R.id.main_container);

    }
}
