package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DishDetails extends AppCompatActivity {

    TextView
            getTheNameOfTheDish,
            getThePriceOfTheDish,
            getGetTheIngredientsOfTheDish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_details);

        getTheNameOfTheDish = findViewById(R.id.dishNameInDetails);
        getThePriceOfTheDish = findViewById(R.id.dishPriceInDetails);
        getGetTheIngredientsOfTheDish = findViewById(R.id.dishIngrediensInDetails);

    }


    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        String dishName = intent.getExtras().getString("dishName");
        Double dishPrice = intent.getExtras().getDouble("dishPrice");
        String dishIngredients = intent.getExtras().getString("dishIngredients");

        getTheNameOfTheDish.setText(dishName);
        getThePriceOfTheDish.setText(Double.toString(dishPrice));
        getGetTheIngredientsOfTheDish.setText(dishIngredients);
    }
}