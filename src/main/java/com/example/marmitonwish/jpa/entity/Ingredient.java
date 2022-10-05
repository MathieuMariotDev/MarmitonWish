package com.example.marmitonwish.jpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String photo;

    String name;

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient() {
    }

    public Ingredient(String photo, String name) {
        this.photo = photo;
        this.name = name;
    }

    @OneToMany(mappedBy = "ingredient",fetch=FetchType.EAGER)
    List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
