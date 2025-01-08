package Filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import jakarta.servlet.annotation.WebFilter;


@WebFilter({"/InfermierAppointment", "/infermier/appointment.jsp", "/infermier/index.jsp"}) // Liste des URLs

public class SimpleAuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false); // Récupère la session sans en créer une nouvelle
        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);

        // Si l'utilisateur n'est pas connecté, rediriger vers la page de connexion
        if (!isLoggedIn && !req.getRequestURI().endsWith("/login")) {
            res.sendRedirect(req.getContextPath() + "/login");
        } else {
            // L'utilisateur est connecté ou accède à la page de connexion
            chain.doFilter(request, response);
        }
    }
}
