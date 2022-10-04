package com.example.marmitonwish.servlet;

import com.example.marmitonwish.jpa.DaoFactory;
import com.example.marmitonwish.jpa.entity.Recipe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/auth/detailsRecipe")
public class DetailsRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        try {
            long idRecipe = Long.parseLong(idStr);
            Optional<Recipe> recipeOptional = DaoFactory.getRecipeDao().getRecipeById(idRecipe);
            if (recipeOptional.isPresent()) {
                req.setAttribute("recipe", recipeOptional.get());
            }

            req.getRequestDispatcher("/WEB-INF/detailsRecipe.jsp").forward(req, resp);

        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("error_format_id", true);
        }
    }
}
