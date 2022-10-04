package com.example.marmitonwish.jpa.entity;

import jakarta.persistence.*;

@Entity(name="recipe_ingredient")
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    Recipe recipe;


    float quantity;

    String unite;

    public RecipeIngredient() {
    }

    public RecipeIngredient(Ingredient ingredient, Recipe recipe, float quantity, String unite) {
        this.ingredient = ingredient;
        this.recipe = recipe;
        this.quantity = quantity;
        this.unite = unite;
    }

    public RecipeIngredient(float quantity, String unite) {
        this.quantity = quantity;
        this.unite = unite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
}
