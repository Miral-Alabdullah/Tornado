package com.example.tornado;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/*
**********************************************************************************
1- @Database : This annotation indicates that this class is to create the database
2- It requires to specify the entities, in this case we have only one which is Dish
3- This class must be abstract and extends the RoomDatabase
**********************************************************************************
 */

@Database(entities = {Dish.class}, version = 1)
public abstract class DishDatabase extends RoomDatabase {
    //Create an abstract method of type DishDao
    public abstract DishDao dishDao();

    //Create an instance of the Database class
    private static DishDatabase INSTANCE;

    //Function to return the instance
    public static DishDatabase getTheInstance(Context context){
        if(INSTANCE == null){ //If the instance is equal to null then create the instance
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DishDatabase.class, "Dishes")
                    .allowMainThreadQueries().build(); //This chain of methods creates the instance of the database
        }
        //If not, return the instance
        return INSTANCE;
    }
}
