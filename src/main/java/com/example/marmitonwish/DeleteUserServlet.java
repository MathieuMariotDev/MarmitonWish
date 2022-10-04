package com.example.marmitonwish;

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
        String idStr = req.getParameter("idUser");

        try {
            long id = Long.parseLong(idStr);
            req.setAttribute("idUser", id);

        } catch (NumberFormatException e) {
            req.setAttribute("error_format_id", true);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/removeUser.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("idUser");

        try {
            long idUser = Long.parseLong(idStr);
            DaoFactory.getUserDAO().delete(idUser);

            resp.sendRedirect(req.getContextPath() + "#"); // a completer

        } catch (NumberFormatException e) {
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/removeUser.jsp");
            req.setAttribute("error_format_id", true);
            rd.forward(req, resp);
        }
    }
}
