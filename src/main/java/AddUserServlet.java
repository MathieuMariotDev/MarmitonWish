import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add_user")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/addUserForm.jsp");
        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        String firstname = req.getParameter("firstName");
        // mot de passe a hashe pour la securite
        String mdp = req.getParameter("password");
        String email = req.getParameter("email");
        String photo = req.getParameter("photo");
        User user = new user(userName,firstname,mdp,email,photo);

        Daofactory.getUserDAO().create(user);

        resp.sendRedirect(req.getContextPath()+"/showProfile");


    }
}
