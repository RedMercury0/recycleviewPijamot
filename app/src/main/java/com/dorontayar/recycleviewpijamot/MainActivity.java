package com.dorontayar.recycleviewpijamot;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SelectListener{
    private RecyclerView recyclerView;
    private ArrayList<CharacterModel> dataSet;
    private CharacterAdapter adapter;

    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Display all the characters in a card view
        displayItems();

        // The search bar logic
        itemSearchBar();
    }
    private void itemSearchBar(){
        searchView = findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });
    }

    private void filter(String newText) {
        ArrayList<CharacterModel> filteredList = new ArrayList<>();
        for(CharacterModel item: dataSet){
            if(item.getName().toLowerCase().contains(newText.toLowerCase()) || item.getDescription().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }

    private void displayItems(){
        dataSet = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for ( int i = 0 ; i < PijamotData.drawableArray.length ; i++){

            dataSet.add(new CharacterModel(
                    PijamotData.nameArray[i],
                    PijamotData.drawableArray[i],
                    PijamotData.descriptionArray[i]

            ));
        }

        adapter = new CharacterAdapter(this,dataSet,this);
        recyclerView.setAdapter(adapter);
    }


    private void showPopup(CharacterModel model) {
        // show a popup message with character details
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(model.getName())
                .setMessage(model.getDescription())
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }

    @Override
    public void onItemClicker(CharacterModel model) {
        showPopup(model);
    }
}