package com.example.marmitonwish.model;

import com.example.marmitonwish.jpa.entity.Recipe;
import com.example.marmitonwish.jpa.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class CookedRecipeDto {

    Long id;


    User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateCook() {
        return dateCook;
    }

    public void setDateCook(LocalDateTime dateCook) {
        this.dateCook = dateCook;
    }

    Recipe recipe;

    LocalDateTime dateCook;

    public CookedRecipeDto(Long id, User user, Recipe recipe, LocalDateTime dateCook) {
        this.id = id;
        this.user = user;
        this.recipe = recipe;
        this.dateCook = dateCook;
    }

    public CookedRecipeDto() {
    }
}
