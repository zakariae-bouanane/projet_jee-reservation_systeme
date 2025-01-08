
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.AppointmentDAO;
import Models.Appointment;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/InfermierAppointment")
public class InfermierAppointment extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
	
	public InfermierAppointment() {
		super();
	}

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            // Rediriger vers la page appointment.jsp
            response.sendRedirect("infermier/appointment.jsp");
        } else {
            // Autres actions, ou afficher des informations si nécessaire
            ArrayList<Appointment> appointments = AppointmentDAO.getAll();
            request.setAttribute("appointments", appointments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/infermier/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    // Méthode pour ajouter un rendez-vous
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String department = request.getParameter("department");
        String doctor = request.getParameter("doctor");
        String date = request.getParameter("date");
        String message = request.getParameter("message");

        // Créer un nouvel objet Appointment
        Appointment appointment = new Appointment(name, email, phone, department, doctor, date, message);

        // Enregistrer l'objet dans la base de données via AppointmentDAO
        try {
            AppointmentDAO.save(appointment);
             // Rediriger vers la page des rendez-vous
        response.sendRedirect("InfermierAppointment");
        } catch (SQLException e) {
            e.printStackTrace();
            // En cas d'erreur, afficher un message d'erreur à l'utilisateur
            request.setAttribute("errorMessage", "Erreur lors de l'ajout du rendez-vous. Veuillez réessayer.");
            request.setAttribute("exceptionMessage", e.getMessage()); 
            RequestDispatcher dispatcher = request.getRequestDispatcher("/infermier/appointment.jsp");
            dispatcher.forward(request, response);
        }

       
    }

}

