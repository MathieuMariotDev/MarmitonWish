package com.example.marmitonwish.servlet;

import com.example.marmitonwish.jpa.DaoFactory;
import com.example.marmitonwish.jpa.entity.Recipe;
import com.example.marmitonwish.jpa.entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Optional;

@WebServlet("/editRecipe")
public class EditRecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            long id = Long.parseLong(req.getParameter("id"));
            Optional<Recipe> recipe =  DaoFactory.getRecipeDao().getRecipeById(id);
            req.setAttribute("recipe",recipe.get());
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            req.setAttribute("user",user);
        }catch (NumberFormatException | NoSuchElementException e){
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("recipe_not_found", true);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/editRecipeForm.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String recipeName = req.getParameter("newRecipeName");
           float timeToPrepare = Float.parseFloat(req.getParameter("newTimeToPrepare"));
          String dificulty = req.getParameter("newDificulty");
            int portion = Integer.parseInt(req.getParameter("newPortion"));
            float price = Float.parseFloat(req.getParameter("newPrice"));
            String preparation = req.getParameter("newPreparation");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
            LocalDateTime localDate = LocalDateTime.now();


           long  recipeId = Long.parseLong(req.getParameter("recipeId"));

            Optional<Recipe> recipeOptional = DaoFactory.getRecipeDao().getRecipeById(recipeId);
            Recipe recipe   = recipeOptional.get();

            recipe.setRecipeName(recipeName);
            recipe.setDificulty(dificulty);
            recipe.setTimeToPrepare(timeToPrepare);
            recipe.setPortion(portion);
            recipe.setPrice(price);
            recipe.setPreparation(preparation);
            recipe.setCreateDate(localDate);
            DaoFactory.getRecipeDao().updateRecipe(recipe);
        }catch(NumberFormatException e){
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("error_format_id", true);
        }
        resp.sendRedirect(req.getContextPath() + "/recipes");
    }

}

