package com.example.marmitonwish.model;

import com.example.marmitonwish.jpa.entity.Ingredient;
import com.example.marmitonwish.jpa.entity.Recipe;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class RecipeIngredientDto {

    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    float quantity;

    String unite;

    public RecipeIngredientDto() {
    }

    public RecipeIngredientDto(Long id, float quantity, String unite) {
        this.id = id;
        this.quantity = quantity;
        this.unite = unite;
    }
}
