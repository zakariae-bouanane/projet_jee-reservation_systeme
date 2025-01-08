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

import DAO.AppointmentDAO;

@WebServlet("/appointment")
public class appointment extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
	
	public appointment() {
		super();
	}

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String department = request.getParameter("department");
        String doctor = request.getParameter("doctor");
        String date = request.getParameter("date");
        String message = request.getParameter("message");

        Appointment appointment = new Appointment(name, email, phone, department, doctor, date, message);
        AppointmentDAO appointmentDAO = new AppointmentDAO();

        try {
            appointmentDAO.save(appointment);
            response.sendRedirect("index.jsp?success=true");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?success=false");
        }

        // Redirect with a success message
        // response.sendRedirect("index.jsp");

        }
}