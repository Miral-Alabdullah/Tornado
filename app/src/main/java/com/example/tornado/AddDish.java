package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDish extends AppCompatActivity {

    Button saveTheDataBtn;
    EditText
            addTheDishName,
            addThePrice,
            addTheIngredients;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish);

        addTheDishName = findViewById(R.id.dishNameInputField);
        addThePrice = findViewById(R.id.dishPriceInputField);
        addTheIngredients = findViewById(R.id.ingredientsInputField);
        saveTheDataBtn = findViewById(R.id.submitTheForm);
    }


    @Override
    protected void onStart() {
        super.onStart();
        saveTheDataBtn.setOnClickListener(view -> {
            Toast.makeText(this.getApplicationContext(), "Saved!", Toast.LENGTH_SHORT).show();

            //Pass the input in the form to the saveTheData method
            saveTheData(addTheDishName.getText().toString(), Double.parseDouble(addThePrice.getText().toString()),
                        addTheIngredients.getText().toString());

        });
    }


    private void saveTheData(String Name, double Price, String Ingredients){
        //Get The instance of the database
        DishDatabase dishDatabase = DishDatabase.getTheInstance(this.getApplicationContext());
        Dish dish = new Dish();
        dish.Name = Name;
        dish.Price = Price;
        dish.Ingredients = Ingredients;

        dishDatabase.dishDao().insertDishes(dish); //Add the data using the insert method that declared in the Dao

        finish(); //Finish the method

    }
}