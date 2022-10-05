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
        String idStr = req.getParameter("id");

        try {
            long idRecipe = Long.parseLong(idStr);
            req.setAttribute("idRecipe", idRecipe);

        } catch (NumberFormatException e) {
            req.setAttribute("error_format_id", true);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/removeRecipe.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        try {
            long idDelete = Long.parseLong(idStr);

            DaoFactory.getRecipeDao().deleteRecipe(idDelete);

            resp.sendRedirect(req.getContextPath() + "/recipes");

        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("error_format_id", true);
        }

    }
}
