package com.example.marmitonwish.servlet;


import com.example.marmitonwish.jpa.DaoFactory;
import com.example.marmitonwish.jpa.entity.Ingredient;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static com.example.marmitonwish.jpa.DaoFactory.getIngredientDao;

@WebServlet("/addIngredientToRecipe")
public class AddIngredientToRecipe extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Long idRecipe = Long.valueOf(req.getParameter("id"));
        }catch(NumberFormatException e){
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
        super.doPost(req, resp);
    }
}
