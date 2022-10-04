package com.example.marmitonwish;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/detailsUser")
public class DetailsUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        try {
            long idUser = Long.parseLong(idStr);
            Optional<User> userOptional = DaoFactory.getUserDAO().findById(idUser);

            if (userOptional.isPresent()) {
                req.setAttribute("user", userOptional.get());
            }

        } catch (NumberFormatException e) {
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/removeUser.jsp");
            req.setAttribute("error_format_id", true);
            rd.forward(req, resp);
        }



        req.getRequestDispatcher("/WEB-INF/detailsUser.jsp").forward(req, resp);
    }
}
