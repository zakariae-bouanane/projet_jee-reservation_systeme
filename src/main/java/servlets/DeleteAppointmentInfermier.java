
package servlets;

import java.io.IOException;

import DAO.AppointmentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/DeleteAppointmentInfermier")
public class DeleteAppointmentInfermier extends HttpServlet {
   

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String message;

        try {
            
            int id = Integer.parseInt(idStr);

            
            AppointmentDAO dao = new AppointmentDAO();
            boolean success = dao.deleteAppointment(id);

           
            if (success) {
                message = "Le rendez-vous a été supprimé avec succès.";
            } else {
                message = "Échec de la suppression du rendez-vous. Veuillez réessayer.";
            }
        } catch (NumberFormatException e) {
            message = "L'ID du rendez-vous est invalide.";
        } catch (Exception e) {
            message = "Une erreur s'est produite : " + e.getMessage();
            e.printStackTrace();
        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("InfermierAppointments.jsp").forward(request, response);
    }
}
