package com.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.model.RecipeResult;
import com.example.myapplication.R;


import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private List<RecipeResult> recipeList;

    public RecipeAdapter(List<RecipeResult> recipeList) {
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        RecipeResult recipe = recipeList.get(position);
        holder.nameTextView.setText(recipe.getName());
        holder.ingredientsTextView.setText(recipe.getIngredients());
        holder.stepsTextView.setText(recipe.getSteps());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    static class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView ingredientsTextView;
        TextView stepsTextView;

        RecipeViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.recipe_name);
            ingredientsTextView = itemView.findViewById(R.id.recipe_ingredients);
            stepsTextView = itemView.findViewById(R.id.recipe_steps);
        }
    }
}
