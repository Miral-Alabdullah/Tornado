package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button goToHomePage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        goToHomePage = findViewById(R.id.gotToHomeBtn);
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