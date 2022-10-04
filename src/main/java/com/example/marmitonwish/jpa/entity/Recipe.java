package com.example.marmitonwish.jpa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity(name="recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String recipeName;

    float timeToPrepare;

    String dificulty;

    int portion;

    float price;

    public Recipe() {
    }

    public Recipe(String recipeName, float timeToPrepare, String dificulty, int portion, float price, LocalDateTime createDate, String preparation, User user) {
        this.recipeName = recipeName;
        this.timeToPrepare = timeToPrepare;
        this.dificulty = dificulty;
        this.portion = portion;
        this.price = price;
        this.createDate = createDate;
        this.preparation = preparation;
        this.user = user;
    }

    LocalDateTime createDate;

    @Lob
    @Column(columnDefinition = "TEXT")
    String preparation;

    @ManyToOne
    User user;

    @OneToMany(mappedBy = "recipe")
    List<CookedRecipe> cookedRecipes;


    @OneToMany(mappedBy = "recipe")
    List<RecipeIngredient> recipeIngredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<CookedRecipe> getCookedRecipes() {
        return cookedRecipes;
    }

    public void setCookedRecipes(List<CookedRecipe> cookedRecipes) {
        this.cookedRecipes = cookedRecipes;
    }
}