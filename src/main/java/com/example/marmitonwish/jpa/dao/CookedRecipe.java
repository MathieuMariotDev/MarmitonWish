package com.example.marmitonwish.jpa.dao;

import java.util.List;
import java.util.Optional;

public interface CookedRecipe {

    List<CookedRecipe> findAll();

    boolean addCookedRecipe(CookedRecipe cookedRecipe);

    boolean deleteCookedRecipe(long id);

    boolean updateCookedRecipe(CookedRecipe cookedRecipe);

    Optional<CookedRecipe> getCookedRecipeById(long id);

}
