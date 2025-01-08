package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import DAO.DbConnexion;
import DAO.UserDAO;
import Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp"); 
    }





    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Connexion à la base de données
        Connection connection = null;
        try {
            connection = DbConnexion.getConnexion(); 
        } catch (SQLException e) {
            // En cas d'erreur de connexion à la base de données
            request.setAttribute("error", "Erreur de connexion à la base de données.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return; 
        }

        UserDAO userDAO = new UserDAO(connection);

        // Vérification de l'utilisateur
        User user = userDAO.getUserByUsernameAndPassword(email, password);

        if (user != null) {
            // Connexion réussie
            HttpSession session = request.getSession();
            session.setAttribute("user", user); 
            response.sendRedirect("InfermierAppointment"); 
            
        } else {
            // Échec de la connexion
            request.setAttribute("error", "Nom d'utilisateur ou mot de passe incorrect.");
            request.getRequestDispatcher("login.jsp").forward(request, response); 
        }
    }
}
