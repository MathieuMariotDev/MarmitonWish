package com.example.marmitonwish.servlet;

import com.example.marmitonwish.jpa.DaoFactory;
import com.example.marmitonwish.jpa.entity.CookedRecipe;
import com.example.marmitonwish.jpa.entity.Recipe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@WebServlet("/random")
public class RandomRecipeServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CookedRecipe> cookedRecipeList = DaoFactory.getCookedRecipeDao().findAll();

        List<CookedRecipe> cookedRecipeListDateOk = new ArrayList<>();
        System.out.println("COUCOUC JE SUIS ICI 1");
        // current date
        DateTimeFormatter.ofPattern("uuuu/MM/dd");
        LocalDateTime localDate = LocalDateTime.now();

        LocalDateTime dateMinusSixDays = localDate.minusDays(6);

        //try {
            System.out.println("COUCOUC JE SUIS ICI 2");
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



            long id = cookedRecipeRandom.getRecipe().getId();


            System.out.println("COUCOUC JE SUIS ICI");
            resp.sendRedirect(req.getContextPath() + "/detailsRecipe?id="+id);




       /* } catch (Exception e) {
            System.out.println("COUCOUC JE SUIS ICI 4");
            // TODO
        }*/
    }
}

