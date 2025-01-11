package servlets;

import DAO.AppointmentDAO;
import DAO.PatientDAO;
import Models.Appointment;
import Models.Patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;

@WebServlet("/LoginPatient") 
public class PatientServlet extends HttpServlet {
   
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("Patient/Login.jsp") ;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve email and password from the request
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        PatientDAO patientDAO = new PatientDAO() ;

        // Verify patient credentials
        Patient patient = null;
		try {
			patient = patientDAO.verifyPatient(email, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if (patient != null) {
            request.getSession().setAttribute("patient", patient);
            request.getSession().setAttribute("patientEmail", patient.getEmail());
            AppointmentDAO appointmentDAO = new AppointmentDAO();
            List<Appointment> appointments = appointmentDAO.getAppointmentsByPatientEmail(email);

            // Set the appointments in the request scope to pass to the JSP
            request.setAttribute("appointments", appointments);
            request.getRequestDispatcher("/Patient/PatientAppointment.jsp").forward(request, response);
        } 
        else 
        {
            request.getRequestDispatcher("/Patient/Login.jsp").forward(request, response); 
        }
    }
}
