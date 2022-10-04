package com.example.marmitonwish.servlet;

import com.example.marmitonwish.jpa.DaoFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Optional;

@WebServlet("/addRecipe")
public class AddRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            long id = Long.parseLong(req.getParameter("id"));
            Optional<Recipe> recipe =  DaoFactory.getRecipeDao().getRecipeById(id);
            req.setAttribute("recipe",recipe.get());
        }catch (NumberFormatException | NoSuchElementException e){
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("recipe_not_found", true);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/editUserForm.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recipeName = req.getParameter("recipeName");
        float timeToPrepare = Float.parseFloat(req.getParameter("timeToPrepare"));
        String dificulty = req.getParameter("dificulty");
        int portion = Integer.parseInt(req.getParameter("portion"));
        float price = Float.parseFloat(req.getParameter("price"));
        String preparation = req.getParameter("preparation");


      try {
          HttpSession session = req.getSession();
          User user = session.getAttribute("user");

          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
          LocalDate localDate = LocalDate.now();
          resp.getWriter().println(localDate);

          Recipe recipe = new recipe(recipeName, timeToPrepare, dificulty, portion, price, localDate, preparation, user);


          DaoFactory.getRecipeDao().addRecipe(recipe);
      }catch(Exception e){
          resp.sendRedirect(req.getContextPath() + "/error");
          req.setAttribute("error_format_id", true);
        }

        resp.sendRedirect(req.getContextPath() + "/recipes");
    }

}
