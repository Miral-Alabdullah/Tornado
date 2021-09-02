package com.example.tornado;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

//Extends the Adapter class in order to indicate that it is an Adapter class
public class DishAdapter extends RecyclerView.Adapter<DishAdapter.DishViewHolder>{
    List<Dish> dishes;

    public DishAdapter(List<Dish> dishes) {
        this.dishes = dishes;
    }

    //This class is to wrap the data and the view objects
    public static class DishViewHolder extends RecyclerView.ViewHolder{

        public Dish dish;
        View itemView;

        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            //Add the onClickListener For each item
            itemView.findViewById(R.id.layoutFragment).setOnClickListener(view -> {
                Intent goToDetailPage = new Intent(view.getContext(), DishDetails.class);
                goToDetailPage.putExtra("dishName", dish.Name);
                goToDetailPage.putExtra("dishPrice", dish.Price);
                goToDetailPage.putExtra("dishIngredients", dish.Ingredients);
                view.getContext().startActivity(goToDetailPage);
            });
        }
    }


    @NotNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create the view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dish, parent, false);
        return new DishViewHolder(view);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull DishViewHolder holder, int position) {
        holder.dish = dishes.get(position); //Each dish based on its position in the List

        TextView dishName = holder.itemView.findViewById(R.id.dishNameTextView);
        TextView dishPrice = holder.itemView.findViewById(R.id.dishPriceTextView);

        dishName.setText(holder.dish.Name);
        dishPrice.setText(Double.toString(holder.dish.Price));

    }

    @Override
    public int getItemCount() {
        return dishes.size(); //return the list no matter how much its size
    }

}
