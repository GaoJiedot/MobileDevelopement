package com.example.model;
import com.google.gson.annotations.SerializedName;

public class RecipeResult {
    @SerializedName("name")
    private String name;

    @SerializedName("ingredients")
    private String ingredients;

    @SerializedName("steps")
    private String steps;

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "RecipeResult{" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", steps='" + steps + '\'' +
                '}';
    }
}
