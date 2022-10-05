package com.example.marmitonwish.servlet;

import com.example.marmitonwish.jpa.DaoFactory;
import com.example.marmitonwish.jpa.entity.Recipe;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/searchRecipe")
public class searchRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/searchRecipeForm.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        String name = req.getParameter("recipeName");

        if (name != null) {
            try {
                Optional<Recipe> recipeList = DaoFactory.getRecipeDao().getByName(name);
                req.setAttribute("recipes", recipeList);

                RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/foundRecipe.jsp");
                rd.forward(req, resp);

            } catch (Exception e) {
                resp.sendRedirect(req.getContextPath() + "/error");
                req.setAttribute("user_not_found", true);
            }
        }


        if (category != null) {
            try {
                Optional<Recipe> recipeList = DaoFactory.getRecipeDao().getByCategory(category);
                req.setAttribute("recipes", recipeList);

                RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/foundRecipe.jsp");
                rd.forward(req, resp);
            } catch (Exception e) {
                resp.sendRedirect(req.getContextPath() + "/error");
                req.setAttribute("user_not_found", true);
            }
        }
    }

}
