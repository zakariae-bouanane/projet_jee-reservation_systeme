
package servlets;

import java.io.IOException;

import DAO.AppointmentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
   

    @WebServlet("/ConfirmerRendezVous")
public class ConfirmationInfermierServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String appointmentId = request.getParameter("id");

        try {
            AppointmentDAO dao = new AppointmentDAO();
            boolean isConfirmed = dao.confirmerRendezVous(appointmentId);

            if (isConfirmed) {
                response.sendRedirect("infermier/index.jsp?success=Le rendez-vous a été confirmé.");
            } else {
                response.sendRedirect("infermier/index.jsp?error=Erreur lors de la confirmation du rendez-vous.");
            }
        } catch (Exception e) {
            request.setAttribute("exceptionMessage", "Erreur technique : " + e.getMessage());
            request.getRequestDispatcher("InfermierAppointments.jsp").forward(request, response);
        }
    }
}
