package com.example.marmitonwish.servlet;

import com.example.marmitonwish.jpa.DaoFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
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
        }catch (NumberFormatException | NoSuchElementException e){
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("user_not_found", true);
        }
    }
}
