package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer la session actuelle
        HttpSession session = request.getSession(false); // Récupère la session sans en créer une nouvelle

        if (session != null) {
            // Supprimer l'attribut "user" de la session pour déconnecter l'utilisateur
            session.invalidate();
        }

        // Rediriger vers la page de connexion
        response.sendRedirect(request.getContextPath() + "/login");
    }
}
