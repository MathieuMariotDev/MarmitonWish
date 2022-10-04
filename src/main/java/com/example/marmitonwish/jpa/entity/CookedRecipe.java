package com.example.marmitonwish.jpa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class CookedRecipe {
    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    Recipe recipe;

    LocalDateTime dateCook;

    public CookedRecipe() {
    }

    public CookedRecipe(User user, Recipe recipe, LocalDateTime dateCook) {
        this.user = user;
        this.recipe = recipe;
        this.dateCook = dateCook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public LocalDateTime getDateCook() {
        return dateCook;
    }

    public void setDateCook(LocalDateTime dateCook) {
        this.dateCook = dateCook;
    }
}
