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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet("/foundRecipe")
public class FoundRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        String nameRecipe = req.getParameter("recipename");


        List<Recipe> recipeList = new ArrayList<>();
        if (nameRecipe == null){
            recipeList = DaoFactory.getRecipeDao().getByCategory(category);
        }
        if(category ==null){
            recipeList = DaoFactory.getRecipeDao().getByName(nameRecipe);
        }else if(category != null && nameRecipe != null){
            recipeList = DaoFactory.getRecipeDao().getByName(nameRecipe);
            recipeList.stream().map(recipe -> recipe.getCategory().equals(category)).collect(Collectors.toList());
        }

        req.setAttribute("recipes", recipeList);

        RequestDispatcher rd = req.getRequestDispatcher( "/WEB-INF/recipesList.jsp");
        rd.forward(req,resp);
    }
}
