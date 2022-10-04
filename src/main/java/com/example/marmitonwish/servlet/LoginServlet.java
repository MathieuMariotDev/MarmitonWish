package com.example.marmitonwish.servlet;

import com.example.marmitonwish.jpa.DaoFactory;
import com.example.marmitonwish.jpa.PersistenceManager;
import com.example.marmitonwish.jpa.UserDao;
import com.example.marmitonwish.jpa.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String email = req.getParameter("email");
            String mdp = req.getParameter("mdp");

            Optional<User> user = DaoFactory.getUserDao().getUserByEmail(email);

            if (user.isPresent()) {

                // check password
                String userMdp = user.get().getMdp(); // password associated to email

                if (userMdp.equals(mdp)) {

                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);

                    resp.getWriter().println(session.getAttribute("user"));

                    resp.sendRedirect(req.getContextPath() + "/#");

                } else {
                    req.setAttribute("error_password", "Mot de passe invalide");
                    RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.jsp");
                    rd.forward(req, resp);
                }

            } else {
                req.setAttribute("error_email", "Email invalide");
                RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.jsp");
                rd.forward(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
