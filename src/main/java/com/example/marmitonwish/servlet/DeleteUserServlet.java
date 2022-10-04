package com.example.marmitonwish.servlet;

import com.example.marmitonwish.jpa.DaoFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        try {
            long id = Long.parseLong(idStr);
            req.setAttribute("idUser", id);

        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("error_format_id", true);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/removeUser.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");

        try {
            long idUser = Long.parseLong(idStr);
            DaoFactory.getUserDao().deleteUser(idUser);

            resp.sendRedirect(req.getContextPath() + "#"); // a completer //TODO

        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("error_format_id", true);
        }



    }
}
