package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/appointment")
public class appointment extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
	
	public appointment() {
		super();
	}

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
       // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String department = request.getParameter("department");
        String doctor = request.getParameter("doctor");
        String date = request.getParameter("date");
        String message = request.getParameter("message");

        // Create a new ArrayList for the current form submission
        ArrayList<String> formData = new ArrayList<>();
        formData.add(name);
        formData.add(email);
        formData.add(phone);
        formData.add(department);
        formData.add(doctor);
        formData.add(date);
        formData.add(message);

        // Retrieve the session and the list of form submissions
        HttpSession session = request.getSession();
        ArrayList<ArrayList<String>> allFormData = (ArrayList<ArrayList<String>>) session.getAttribute("allFormData");

        // If the session doesn't already contain a list, initialize it
        if (allFormData == null) {
            allFormData = new ArrayList<>();
        }

        // Add the current form data to the list
        allFormData.add(formData);

        // Store the updated list back in the session
        session.setAttribute("allFormData", allFormData);

        // Redirect with a success message
        response.sendRedirect("index.jsp");

        }
}
