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


@WebServlet("/auth/edit_user")
public class EditUserFile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            long id = Long.parseLong(req.getParameter("id"));
            Optional<User> user =  DaoFactory.getUserDao().getUserById(id);
            req.setAttribute("user",user.get());
        }catch (NumberFormatException | NoSuchElementException e){
            resp.sendRedirect(req.getContextPath() + "/error");
            req.setAttribute("user_not_found", true);
        }


        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/editUserForm.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
       try{
           long id = Long.parseLong(req.getParameter("userId"));
           Optional<User> userOptional = DaoFactory.getUserDao().getUserById(id);
           user = userOptional.get();

           String userName = req.getParameter("newName");
           String firstname = req.getParameter("newFirstName");
           // mot de passe a hashe pour la securite
           String mdp = req.getParameter("newPassword");
           String email = req.getParameter("newEmail");
           String photo = req.getParameter("newUrlPicture");
           user.setName(userName);
           user.setFirstname(firstname);
           user.setEmail(email);
           user.setMdp(mdp);
           user.setPhoto(photo);
           DaoFactory.getUserDao().updateUser(user);
       }catch (NumberFormatException | NoSuchElementException e){
           resp.sendRedirect(req.getContextPath() + "/error");
           req.setAttribute("user_not_found", true);
       }
        resp.sendRedirect(req.getContextPath()+"/detailsUser?id="+user.getId());
    }
}
