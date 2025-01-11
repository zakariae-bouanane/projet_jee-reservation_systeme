<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Confirm Appointment Deletion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-body text-center">
                <h3 class="card-title text-danger">Delete Appointment</h3>
                <p class="card-text">Are you sure you want to delete this appointment?</p>
                <div class="mt-4">
                    <!-- Confirm deletion -->
                    <a href="../DeleteAppointment?appointmentId=<%= request.getParameter("appointmentId") %>" 
                        class="btn btn-danger">Yes, Delete</a>
                    <!-- Cancel deletion -->
                    <a href="PatientAppointment" class="btn btn-secondary">Cancel</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
