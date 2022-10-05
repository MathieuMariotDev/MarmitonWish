package com.example.marmitonwish.model;

import com.example.marmitonwish.jpa.entity.CookedRecipe;
import com.example.marmitonwish.jpa.entity.RecipeIngredient;
import com.example.marmitonwish.jpa.entity.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RecipeDto {


    Long id;

    String recipeName;

    float timeToPrepare;

    String dificulty;

    int portion;

    float price;

    String category;

    public RecipeDto() {
    }

    public RecipeDto(Long id, String recipeName, float timeToPrepare, String dificulty, int portion, float price, String category, LocalDateTime createDate, String preparation, User user, List<CookedRecipeDto> cookedRecipes, List<RecipeIngredientDto> recipeIngredients) {
        this.id = id;
        this.recipeName = recipeName;
        this.timeToPrepare = timeToPrepare;
        this.dificulty = dificulty;
        this.portion = portion;
        this.price = price;
        this.category = category;
        this.createDate = createDate;
        this.preparation = preparation;
        this.user = user;
        this.cookedRecipes = cookedRecipes;
        this.recipeIngredients = recipeIngredients;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public float getTimeToPrepare() {
        return timeToPrepare;
    }

    public void setTimeToPrepare(float timeToPrepare) {
        this.timeToPrepare = timeToPrepare;
    }

    public String getDificulty() {
        return dificulty;
    }

    public void setDificulty(String dificulty) {
        this.dificulty = dificulty;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }




    LocalDateTime createDate;


    String preparation;


    User user;


    List<CookedRecipeDto> cookedRecipes = new ArrayList<>();



    List<RecipeIngredientDto> recipeIngredients = new ArrayList<>();


}
