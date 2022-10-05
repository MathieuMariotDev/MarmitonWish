package com.example.marmitonwish.servlet;

import com.example.marmitonwish.jpa.DaoFactory;
import com.example.marmitonwish.jpa.entity.CookedRecipe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@WebServlet("/auth/random")
public class RandomRecipeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        try {
            long idRecipe = Long.parseLong(idStr);
            req.setAttribute("idRecipe", idRecipe);

        } catch (NumberFormatException | NoSuchElementException e) {
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("user_not_found", true);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CookedRecipe> cookedRecipeList = DaoFactory.getCookedRecipeDao().findAll();

        List<CookedRecipe> cookedRecipeListDateOk = new ArrayList<>();

        // current date
        DateTimeFormatter.ofPattern("uuuu/MM/dd");
        LocalDateTime localDate = LocalDateTime.now();

        LocalDateTime dateMinusSixDays = localDate.minusDays(6);

        try {

            for (CookedRecipe cookedRecipe : cookedRecipeList) {
                LocalDateTime cookedRecipeDate = cookedRecipe.getDateCook();


                if (cookedRecipeDate.isBefore(dateMinusSixDays)) {

                    cookedRecipeListDateOk.add(cookedRecipe);

                } else {
                    // TODO
                }
            }

            Random random = new Random();
            CookedRecipe cookedRecipeRandom = cookedRecipeListDateOk.get(random.nextInt(cookedRecipeListDateOk.size()));

            long id = cookedRecipeRandom.getId();


            req.setAttribute("idRecipe", id);
            resp.sendRedirect(req.getContextPath() + "/auth/detailsRecipe");




        } catch (Exception e) {

            // TODO
        }
    }
}

