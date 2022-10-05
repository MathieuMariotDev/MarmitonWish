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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Optional;

@WebServlet("/addRecipe")
public class AddRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addRecipeForm.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



      try {
          String recipeName = req.getParameter("recipeName");
          float timeToPrepare = Float.parseFloat(req.getParameter("timeToPrepare"));
          String dificulty = req.getParameter("dificulty");
          int portion = Integer.parseInt(req.getParameter("portion"));
          float price = Float.parseFloat(req.getParameter("price"));
          String preparation = req.getParameter("preparation");
          HttpSession session = req.getSession();
          User user = (User) session.getAttribute("user");

          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
          LocalDateTime localDate = LocalDateTime.now();
          resp.getWriter().println(localDate);

          Recipe recipe = new Recipe(recipeName, timeToPrepare, dificulty, portion, price, localDate, preparation,null, user );



          DaoFactory.getRecipeDao().addRecipe(recipe);
          resp.sendRedirect(req.getContextPath() + "/addIngredientToRecipe?id="+recipe.getId());
      }catch(Exception e){
          resp.sendRedirect(req.getContextPath() + "/error");
          req.setAttribute("error_format_id", true);
        }

    }

}
