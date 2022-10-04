package com.example.marmitonwish.jpa.dao;

import com.example.marmitonwish.jpa.entity.Recipe;
import com.example.marmitonwish.jpa.entity.RecipeIngredient;

import java.util.List;
import java.util.Optional;

public interface RecipeIngredientDao {

    List<RecipeIngredient> findAll();

    boolean addRecipeIngredient(RecipeIngredient recipe);

    boolean deleteRecipeIngredient(long id);

    boolean updateRecipeIngredient(RecipeIngredient recipe);

    Optional<RecipeIngredient> getRecipeIngredientById(long id);


}
