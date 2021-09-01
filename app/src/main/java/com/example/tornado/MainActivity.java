package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button gotToAddDishPage, gotToMenuPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get The Id's for the views
        gotToAddDishPage = findViewById(R.id.toAddDishBtn);
        gotToMenuPage = findViewById(R.id.toMenuBtn);
    }


    @Override
    protected void onStart() {
        super.onStart();

        // Create the onClick listeners
        gotToAddDishPage.setOnClickListener(view -> {
            // Create the Intent in order to navigate to the target activity
            Intent goToDishPageIntent = new Intent(MainActivity.this, AddDish.class);
            // Start the activity by calling the startActivity method and pass the intent to it
            startActivity(goToDishPageIntent);
        });

        gotToMenuPage.setOnClickListener(view -> {
            Intent goToMenuPageIntent = new Intent(MainActivity.this, Menu.class);
            startActivity(goToMenuPageIntent);
        });
    }
}