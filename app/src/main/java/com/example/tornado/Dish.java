package com.example.tornado;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


//Create an entity and its fields, set the primary key to be auto generated
@Entity
public class Dish {
    @PrimaryKey(autoGenerate = true)
    public Integer dishId;
    @ColumnInfo(name = "dish_name")
    public String Name;
    @ColumnInfo(name = "ingredients")
    public String Ingredients;
    @ColumnInfo(name = "price")
    public double Price;

    public Dish() {
    }

    public Dish(String name, String ingredients, double price) {
        Name = name;
        Ingredients = ingredients;
        Price = price;
    }
}
