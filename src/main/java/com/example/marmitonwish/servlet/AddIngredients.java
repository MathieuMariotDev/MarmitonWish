package com.example.marmitonwish.servlet;

import com.example.marmitonwish.jpa.DaoFactory;
import com.example.marmitonwish.jpa.entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addIngredients")
public class AddIngredients extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addIngredientsForm.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ingredientName = req.getParameter("ingredientName");
        String ingredientsPhoto = req.getParameter("ingredientsPhoto");
        // mot de passe a hashe pour la securite

        try{
            Ingredient ingredient = new Ingredient(ingredientsPhoto,ingredientName);
            DaoFactory.getIngredientDao().addIngredient(ingredient);

            resp.sendRedirect(req.getContextPath()+"/ingredients");
        }catch(Exception e){
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("error_format_id", true);
        }



    }
}
