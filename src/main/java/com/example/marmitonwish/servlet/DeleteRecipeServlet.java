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
import java.util.Optional;

@WebServlet("/auth/deleteRecipe")
public class DeleteRecipeServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get id of connected user
        HttpSession session = req.getSession();
        session.getAttribute("user");

        String idStr = req.getParameter("id");

        try {
            long idRecipe = Long.parseLong(idStr);
            req.setAttribute("idRecipe", idRecipe);

            // get id of user who created the recipe
            Optional<Recipe> recipe = DaoFactory.getRecipeDao().getRecipeById(idRecipe);
            User userRecipe = recipe.get().getUser();
            long idUserRecipe = userRecipe.getId();

            if (idRecipe == idUserRecipe) {
                RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/removeRecipe.jsp");
                rd.forward(req, resp);
            }

        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("error_format_id", true);
        }

    }
}
