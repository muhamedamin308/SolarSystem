package com.example.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.CircularArray;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.lang.NullPointerException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private GalaxyViewModel mGalaxyViewModel;
    private RecyclerView recyclerView ; //contain the recycle view we created
    private AdapterManager adapter; // the connection between the arraylist and the recycle view
    private RecyclerView.LayoutManager layoutManager; //  responsible for manage the layout of the data
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Solar System");
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false); //didn't get it too
        layoutManager = new LinearLayoutManager(this);
        adapter = new AdapterManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        mGalaxyViewModel = ViewModelProviders.of(this).get(GalaxyViewModel.class);
        mGalaxyViewModel.getmAllData().observe(this, new Observer<List<GalaxyClass>>() {
            @Override
            public void onChanged(List<GalaxyClass> galaxyClasses) {
                //Update user Interface
                //RecyclerView
                adapter.setgGalaxyList(galaxyClasses);
            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0 ,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int pos = viewHolder.getAdapterPosition();
                mGalaxyViewModel.deleteV(adapter.getPlanetAt(pos));
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.menu2 , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addItem:{
                Intent intent = new Intent(MainActivity.this , AddPlanet.class);
                startActivity(intent);
                }
            default: return super.onOptionsItemSelected(item);
        }
    }
}