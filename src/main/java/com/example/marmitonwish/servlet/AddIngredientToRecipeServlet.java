package com.example.marmitonwish.servlet;


import com.example.marmitonwish.jpa.DaoFactory;
import com.example.marmitonwish.jpa.entity.Ingredient;
import com.example.marmitonwish.jpa.entity.Recipe;
import com.example.marmitonwish.jpa.entity.RecipeIngredient;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@WebServlet("/addIngredientToRecipe")
public class AddIngredientToRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Long idRecipe = Long.valueOf(req.getParameter("id"));
            req.setAttribute("idRecipe",idRecipe);
            Optional<Recipe> recipe = DaoFactory.getRecipeDao().getRecipeById(idRecipe);
            req.setAttribute("recipeIngredients",recipe.get().getRecipeIngredients());
        }catch(NumberFormatException | NoSuchElementException e){
            req.setAttribute("recipe_not_found", true);
            resp.sendRedirect(req.getContextPath() + "/error");
        }

        List<Ingredient> listIngredient = DaoFactory.getIngredientDao().findAll();
        req.setAttribute("ingredients",listIngredient);


        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addIngredientToRecipe.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Long idRecipe = Long.valueOf(req.getParameter("idRecipe"));
            Optional<Recipe> recipe = DaoFactory.getRecipeDao().getRecipeById(idRecipe);
            Long idIngredient = Long.valueOf(req.getParameter("ingredientId"));
            Optional<Ingredient> ingredient =  DaoFactory.getIngredientDao().getIngredientById(idIngredient);
            float quantity = Float.parseFloat(req.getParameter("quantity"));
            String unite = req.getParameter("unite");
            RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient.get(),recipe.get(),quantity,unite);
            DaoFactory.getRecipeIngredientDao().addRecipeIngredient(recipeIngredient);

            resp.sendRedirect(req.getContextPath() + "/addIngredientToRecipe?id="+idRecipe);
        }catch(NumberFormatException | NoSuchElementException e){
            req.setAttribute("recipe_not_found", true);
            resp.sendRedirect(req.getContextPath() + "/error");
        }
    }
}
