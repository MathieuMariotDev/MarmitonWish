import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("edit_ser")
public class EditUserFile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/EditUserForm.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("newName");
        String firstname = req.getParameter("newFirstName");
        // mot de passe a hashe pour la securite
        String mdp = req.getParameter("newPassword");
        String email = req.getParameter("newEmail");
        String photo = req.getParameter("urlPicture");
        User user = new user(userName,firstname,mdp,email,photo);

        Daofactory.getUserDAO().create(user);

        resp.sendRedirect(req.getContextPath()+"/showProfile");


    }
}
