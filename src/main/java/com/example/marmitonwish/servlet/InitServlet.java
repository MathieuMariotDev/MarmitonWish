package com.example.marmitonwish.servlet;

import com.example.marmitonwish.jpa.DaoFactory;
import com.example.marmitonwish.jpa.dao.UserDao;
import com.example.marmitonwish.jpa.entity.Ingredient;
import com.example.marmitonwish.jpa.entity.Recipe;
import com.example.marmitonwish.jpa.entity.RecipeIngredient;
import com.example.marmitonwish.jpa.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/init")
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Ingredient ingredient = new Ingredient("Pommes de terre");
        Ingredient ingredient1 = new Ingredient("Huile d'olive");
        Ingredient ingredient2 = new Ingredient("Oignons");
        Ingredient ingredient3 = new Ingredient("Ail");
        Ingredient ingredient4 = new Ingredient("Crème fraiche");

        DaoFactory.getIngredientDao().addIngredient(ingredient);
        DaoFactory.getIngredientDao().addIngredient(ingredient2);

        User user =  new User("Mathieu","Mariot","0123","math.mariot@gmail.com","www.maPhoto.com");
        DaoFactory.getUserDao().addUser(user);


        Optional<User> userOptional = DaoFactory.getUserDao().getUserById(1);



        Recipe  recipe = new Recipe("Soupe veloutée de potimarron et pommes de terre",10,"Facil",3,5, LocalDateTime.now(),
                "Enlever l'écorce et les pépins du potimarron (il n'est pas obligatoire de le peler, mais dans ce cas, le choisir bio et bien le laver) puis couper la chair en gros morceaux.,Eplucher les pommes de terre puis les couper en gros morceaux.,Faire revenir les oignons et l'ail hachés dans un peu de beurre à feu doux.",null,
                userOptional.get());
        DaoFactory.getRecipeDao().addRecipe(recipe);

        RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient,recipe,100,"gramme");
        RecipeIngredient recipeIngredient2 = new RecipeIngredient(ingredient2,recipe,2,"Unité");

        DaoFactory.getRecipeIngredientDao().addRecipeIngredient(recipeIngredient);

        DaoFactory.getRecipeIngredientDao().addRecipeIngredient(recipeIngredient2);

        Optional<Recipe> optionalRecipe = DaoFactory.getRecipeDao().getRecipeById(1);

        if (optionalRecipe.isPresent()){
            System.out.println(optionalRecipe.get());
        }else{
            System.out.println("errror recipe");
        }

        System.out.println();
    }
}
