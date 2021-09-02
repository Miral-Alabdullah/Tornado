package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    RecyclerView recyclerView;
    Button goToHomePage;
    List<Dish> dishes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        goToHomePage = findViewById(R.id.gotToHomeBtn);

        //Get The Data from the database
        DishDatabase dishDatabase = DishDatabase.getTheInstance(this.getApplicationContext());
        dishes = dishDatabase.dishDao().getAllDishes();

//        //To set the recyclerView we need to to set the adapter and for LayoutManager its optional,
//        // it indicates the way of displaying the items
        recyclerView = findViewById(R.id.recyclerViewToListTheDishes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DishAdapter(dishes));
    }


    @Override
    protected void onStart() {
        super.onStart();

        goToHomePage.setOnClickListener(view -> {
            Intent goToHomePageIntent = new Intent(Menu.this, MainActivity.class);
            startActivity(goToHomePageIntent);
        });
    }
}