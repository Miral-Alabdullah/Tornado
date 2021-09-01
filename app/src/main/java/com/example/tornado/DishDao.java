package com.example.tornado;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao //This annotation indicates that this interface in Dao
public interface DishDao {

    //Here we add a methods without any implementation, those methods represent the CRUD operations


    //To insert the data into the database
    @Insert
    void insertDishes(Dish... dishes);

    //To retrieve the data from the database
    @Query("SELECT * FROM dish")
    List<Dish> getAllDishes(); //In order to get the data we need a list of type Dish, and this method will retrieve them for me.



}
