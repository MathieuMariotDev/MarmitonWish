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
import java.util.NoSuchElementException;
import java.util.Optional;

@WebServlet("/detailsUser")
public class DetailsUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        try {
            long idUser = Long.parseLong(idStr);
            Optional<User> userOptional = DaoFactory.getUserDao().getUserById(idUser);
            req.setAttribute("user", userOptional.get());


        } catch (NumberFormatException | NoSuchElementException e) {
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("user_not_found", true);
        }



        req.getRequestDispatcher("/WEB-INF/detailsUser.jsp").forward(req, resp);
    }
}
