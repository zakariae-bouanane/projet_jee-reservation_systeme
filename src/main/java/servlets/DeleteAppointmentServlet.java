
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.AppointmentDAO;
import Models.Appointment;
import Models.Patient;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import DAO.AppointmentDAO;
@WebServlet("/DeleteAppointment")
public class DeleteAppointmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String appointmentId = request.getParameter("appointmentId");

        if (appointmentId != null) {
            try {
                AppointmentDAO appointmentDAO = new AppointmentDAO();
                boolean success = appointmentDAO.deleteAppointment(Integer.parseInt(appointmentId));

                if (success) {
                    request.getSession().setAttribute("message", "Appointment deleted successfully!");
                } else {
                    request.getSession().setAttribute("error", "Failed to delete the appointment.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.getSession().setAttribute("error", "An error occurred while deleting the appointment.");
            }
        }

        // Redirect back to the appointments page
        String email = (String) request.getSession().getAttribute("patientEmail");
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        List<Appointment> appointments = appointmentDAO.getAppointmentsByPatientEmail(email);

        // Set the appointments in the request scope to pass to the JSP
        request.setAttribute("appointments", appointments);
        request.getRequestDispatcher("/Patient/PatientAppointment.jsp").forward(request, response);
    }
}
