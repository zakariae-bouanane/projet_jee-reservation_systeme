<%@ page import="java.util.ArrayList" %>
<%@ page import="Models.Appointment" %>
<!DOCTYPE html>
<html>
   <head>
        <!-- Meta Tags -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="keywords" content="Site keywords here">
		<meta name="description" content="">
		<meta name='copyright' content=''>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<!-- Title -->
        <title>Reservation system</title>
		    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

		<!-- Favicon -->
        <link rel="icon" href="/gestion_reservation/assets/img/favicon.png">
		
		<!-- Google Fonts -->
		<link href="https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap" rel="stylesheet">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="/gestion_reservation/assets/css/bootstrap.min.css">
		<!-- Nice Select CSS -->
		<link rel="stylesheet" href="/gestion_reservation/assets/css/nice-select.css">
		<!-- Font Awesome CSS -->
        <link rel="stylesheet" href="/gestion_reservation/assets/css/font-awesome.min.css">
		<!-- icofont CSS -->
        <link rel="stylesheet" href="/gestion_reservation/assets/css/icofont.css">
		<!-- Slicknav -->
		<link rel="stylesheet" href="/gestion_reservation/assets/css/slicknav.min.css">
		<!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="/gestion_reservation/assets/css/owl-carousel.css">
		<!-- Datepicker CSS -->
		<link rel="stylesheet" href="/gestion_reservation/assets/css/datepicker.css">
		<!-- Animate CSS -->
        <link rel="stylesheet" href="/gestion_reservation/assets/css/animate.min.css">
		<!-- Magnific Popup CSS -->
        <link rel="stylesheet" href="/gestion_reservation/assets/css/magnific-popup.css">
		
		<!-- Medipro CSS -->
        <link rel="stylesheet" href="/gestion_reservation/assets/css/normalize.css">
        <link rel="stylesheet" href="/gestion_reservation/style.css">
        <link rel="stylesheet" href="/gestion_reservation/assets/css/responsive.css">
        <style>
    .logout-icon i {
        font-size: 15px;
       
    }
</style>

		
    </head>

<body>
<!-- Header Area -->
<header class="header"> 
    <!-- Header Inner -->
    <div class="header-inner">
        <div class="container">
            <div class="inner">
                <div class="row">
                    <div class="col-lg-3 col-md-3 col-12">
                        <!-- Start Logo -->
                        <div class="logo">
                            <a href="index.html"><img src="/gestion_reservation/img/logo.png" alt="#"></a>
                        </div>
                        <!-- End Logo -->
                        <!-- Mobile Nav -->
                        <div class="mobile-nav"></div>
                        <!-- End Mobile Nav -->
                    </div>
                    <div class="col-lg-6 col-md-6 col-12"> <!-- 50% largeur -->
        
    </div>
    <div class="col-lg-2 col-md-3 col-12"> 
       <div class="get-quote">
                           <a href="InfermierAppointment?action=add" class="btn">Book Appointment</a>
								</div>
    </div>
    <div class="col-lg-1 col-md-2 col-12"> <!-- 9% largeur -->
    <div class="get-quote">
<div class="btn">
                           <a href="logout" class="logout-icon "><i class="fas fa-sign-out-alt"></i> </a>
								</div>								</div>

    </div>



                    


                </div>
            </div>
        </div>
    </div>
    <!--/ End Header Inner -->
</header>

    <div class="container mt-5">
        <h1 class="mb-4">Appointments:</h1>

        <%
            ArrayList<Appointment> appointments = (ArrayList<Appointment>) request.getAttribute("appointments");
            if (appointments != null && !appointments.isEmpty()) {
        %>
            <table class="table table-striped table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th>Department</th>
                        <th>Doctor</th>
                        <th>Date</th>
                        <th>Message</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Boucle à travers la liste des rendez-vous et afficher les informations
                        for (Appointment appointment : appointments) {
                    %>
                        <tr>
                            <td><%= appointment.getDepartment() %></td>
                            <td><%= appointment.getDoctor() %></td>
                            <td><%= appointment.getDate() %></td>
                            <td><%= appointment.getMessage() %></td>
                            <td>
                                <a href="Patient/ConfirmDeleteAppointment.jsp?appointmentId=<%= appointment.getId()%>" 
                                class="btn btn-danger btn-sm">
                                Delete
                             </a>
                            </td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        <%
            } else {
        %>
            <div class="alert alert-warning" role="alert">
                No appointments Booked yet.
            </div>
        <%
            }
        %>
    </div>

    <script src="/gestion_reservation/assets/js/bootstrap.min.js"></script>
</body>
</html>
