package com.example.marmitonwish.jpa;

import com.example.marmitonwish.jpa.dao.*;

public class DaoFactory {

    public DaoFactory() {
    }

    public static UserDao getUserDao(){
        return new JpaUserDao();
    }

    public static RecipeDao getRecipeDao(){
        return new JpaRecipeDao();
    }

    public static IngredientDao getIngredientDao(){
        return new JpaIngredientDao();
    }

    public static RecipeIngredientDao getRecipeIngredientDao(){
        return new JpaRecipeIngredient();
    }


}
