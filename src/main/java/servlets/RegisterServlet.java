package servlets;

import DAO.PatientDAO;
import Models.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Register") 
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("Patient/Register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dateDeNaissance = request.getParameter("dateDeNaissance");
        
        
        if (name == null || telephone == null || email == null || password == null || dateDeNaissance == null ||
                name.isEmpty() || telephone.isEmpty() || email.isEmpty() || password.isEmpty() || dateDeNaissance.isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("/Patient/Register.jsp").forward(request, response);
            return;
        }

     
        Patient patient = new Patient();
        patient.setName(name);
        patient.setTelephone(telephone);
        patient.setEmail(email);
        patient.setPassword(password);
        patient.setDateDeNaissance(java.sql.Date.valueOf(dateDeNaissance)); // Convert String to java.sql.Date

      
        boolean isRegistered = PatientDAO.registerPatient(patient);

        if (isRegistered) {
            response.sendRedirect("Patient/Login.jsp?success=true");
        } else {
            // Stay on the registration page with an error message
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            request.getRequestDispatcher("/Patient/Register.jsp").forward(request, response);
        }
    }

}
