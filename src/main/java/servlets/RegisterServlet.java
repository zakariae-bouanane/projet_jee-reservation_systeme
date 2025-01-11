package servlets;

import DAO.PatientDAO;
import Models.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/Register") 
public class RegisterServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(RegisterServlet.class.getName());


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
        PatientDAO patientDAO = new PatientDAO();
        patient.setName(name);
        patient.setTelephone(telephone);
        patient.setEmail(email);
        patient.setPassword(password);
        patient.setDateDeNaissance(java.sql.Date.valueOf(dateDeNaissance)); // Convert String to java.sql.Date

      
        try {
            boolean isRegistered = patientDAO.registerPatient(patient);
            if (isRegistered) {
                response.sendRedirect("Patient/Login.jsp?success=true");
            } else {
                request.setAttribute("errorMessage", "Registration failed. Please try again.");
                request.getRequestDispatcher("/Patient/Register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during registration", e);
            request.setAttribute("errorMessage", "An error occurred during registration. Please try again.");
            request.getRequestDispatcher("/Patient/Register.jsp").forward(request, response);
        }
    }

}
