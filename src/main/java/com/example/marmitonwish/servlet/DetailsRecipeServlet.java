package com.example.marmitonwish.servlet;

import com.example.marmitonwish.jpa.DaoFactory;
import com.example.marmitonwish.jpa.entity.Ingredient;
import com.example.marmitonwish.jpa.entity.Recipe;
import com.example.marmitonwish.jpa.entity.RecipeIngredient;
import com.example.marmitonwish.jpa.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/auth/detailsRecipe")
public class DetailsRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        try {
            // recipe + ingredients info
            long idRecipe = Long.parseLong(idStr);
            Optional<Recipe> recipeOptional = DaoFactory.getRecipeDao().getRecipeById(idRecipe);

            if (recipeOptional.isPresent()) {
                Recipe recipe = recipeOptional.get();
                req.setAttribute("recipe", recipe);

                List<RecipeIngredient> recipeIngredientsList = recipe.getRecipeIngredients();

                // get quantity + unit dans recipeingredient
                req.setAttribute("recipeIngredients", recipeIngredientsList);

                List<Ingredient> ingredientList = new ArrayList<>();
                for (RecipeIngredient recipeIngredient : recipeIngredientsList) {
                    Ingredient ingredient = recipeIngredient.getIngredient();
                    ingredientList.add(ingredient);
                }
                //List<Ingredient> ingredientList = recipeIngredientsList.forEach(recipeIngredient -> recipeIngredient.getIngredient());
                // get name + photo dans ingredient
                req.setAttribute("ingredients", ingredientList);
            }

            // display delete button if connected user is recipe creator
            // get id of connected user
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            long idUser = user.getId();

            req.setAttribute("idRecipe", idRecipe);

            // get id of user who created the recipe
            Optional<Recipe> recipe = DaoFactory.getRecipeDao().getRecipeById(idRecipe);
            User userRecipe = recipe.get().getUser();
            long idUserRecipe = userRecipe.getId();

            if (idUser == idUserRecipe) {
                req.setAttribute("display_delete", true);
            }

            req.getRequestDispatcher("/WEB-INF/detailsRecipe.jsp").forward(req, resp);

        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("error_format_id", true);
        }
    }
}
