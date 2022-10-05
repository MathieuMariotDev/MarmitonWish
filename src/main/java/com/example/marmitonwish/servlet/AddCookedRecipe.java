package com.example.marmitonwish.servlet;

import com.example.marmitonwish.jpa.DaoFactory;
import com.example.marmitonwish.jpa.entity.CookedRecipe;
import com.example.marmitonwish.jpa.entity.Recipe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Optional;

@WebServlet("/auth/addCookedRecipe")
public class AddCookedRecipe extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        try {
            long idRecipe = Long.parseLong(idStr);
            req.setAttribute("idRecipe", idRecipe);

        } catch (NumberFormatException | NoSuchElementException e) {
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("user_not_found", true);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        try {
            long idRecipe = Long.parseLong(idStr);
            Optional<Recipe> optionalRecipe = DaoFactory.getRecipeDao().getRecipeById(idRecipe);

            if (optionalRecipe.isPresent()) {
                Recipe recipe = optionalRecipe.get();

                CookedRecipe cookedRecipe = new CookedRecipe();
                cookedRecipe.setUser(recipe.getUser());
                cookedRecipe.setRecipe(recipe);

                // current date
                DateTimeFormatter.ofPattern("uuuu/MM/dd");
                LocalDateTime localDate = LocalDateTime.now();

                cookedRecipe.setDateCook(localDate);

                DaoFactory.getCookedRecipeDao().addCookedRecipe(cookedRecipe);

                resp.sendRedirect(req.getContextPath() + "/recipes");

            } else {
                // TODO
            }

        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("error_format_id", true);
        }
    }
}
