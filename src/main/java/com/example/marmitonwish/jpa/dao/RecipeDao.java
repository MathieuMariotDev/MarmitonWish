package com.example.marmitonwish.jpa.dao;

import com.example.marmitonwish.jpa.entity.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeDao {

    List<Recipe> findAll();

    boolean addRecipe(Recipe recipe);

    boolean deleteRecipe(long id);

    boolean updateRecipe(Recipe recipe);

    Optional<Recipe> getRecipeById(long id);


}
