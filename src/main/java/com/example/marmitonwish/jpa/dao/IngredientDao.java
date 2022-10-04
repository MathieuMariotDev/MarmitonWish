package com.example.marmitonwish.jpa.dao;

import com.example.marmitonwish.jpa.entity.Ingredient;
import com.example.marmitonwish.jpa.entity.Recipe;

import java.util.List;
import java.util.Optional;

public interface IngredientDao {

    List<Ingredient> findAll();

    boolean addIngredient(Ingredient ingredient);

    boolean deleteIngredient(long id);

    boolean updateIngredient(Recipe ingredient);

    Optional<Ingredient> getIngredientById(long id);

}
