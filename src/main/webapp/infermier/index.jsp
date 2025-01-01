<%@ page import="java.util.ArrayList" %>
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
		
		<!-- Favicon -->
        <link rel="icon" href="../assets/img/favicon.png">
		
		<!-- Google Fonts -->
		<link href="https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap" rel="stylesheet">

		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="../assets/css/bootstrap.min.css">
		<!-- Nice Select CSS -->
		<link rel="stylesheet" href="../assets/css/nice-select.css">
		<!-- Font Awesome CSS -->
        <link rel="stylesheet" href="../assets/css/font-awesome.min.css">
		<!-- icofont CSS -->
        <link rel="stylesheet" href="../assets/css/icofont.css">
		<!-- Slicknav -->
		<link rel="stylesheet" href="../assets/css/slicknav.min.css">
		<!-- Owl Carousel CSS -->
        <link rel="stylesheet" href="../assets/css/owl-carousel.css">
		<!-- Datepicker CSS -->
		<link rel="stylesheet" href="../assets/css/datepicker.css">
		<!-- Animate CSS -->
        <link rel="stylesheet" href="../assets/css/animate.min.css">
		<!-- Magnific Popup CSS -->
        <link rel="stylesheet" href="../assets/css/magnific-popup.css">
		
		<!-- Medipro CSS -->
        <link rel="stylesheet" href="../assets/css/normalize.css">
        <link rel="stylesheet" href="../style.css">
        <link rel="stylesheet" href="../assets/css/responsive.css">
		
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
                            <a href="index.html"><img src="../img/logo.png" alt="#"></a>
                        </div>
                        <!-- End Logo -->
                        <!-- Mobile Nav -->
                        <div class="mobile-nav"></div>
                        <!-- End Mobile Nav -->
                    </div>

                </div>
            </div>
        </div>
    </div>
    <!--/ End Header Inner -->
</header>

    
    <% 
        // Retrieve the session and the list of form submissions (ArrayList<ArrayList<String>>)
        ArrayList<ArrayList<String>> allFormData = (ArrayList<ArrayList<String>>) session.getAttribute("allFormData");
    %>

    <div class="container mt-5">
        <h1 class="mb-4">Appointments :</h1>
        
        <c:if test="${not empty allFormData}">
            <table class="table table-striped table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Department</th>
                        <th>Doctor</th>
                        <th>Date</th>
                        <th>Message</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%-- Loop through each form submission in the ArrayList of form data --%>
                    <%
                        if (allFormData != null) {
                            for (ArrayList<String> form : allFormData) {
                    %>
                        <tr>
                            <%-- Display each field of the form in separate table cells --%>
                            <td><%= form.get(0) %></td>
                            <td><%= form.get(1) %></td>
                            <td><%= form.get(2) %></td>
                            <td><%= form.get(3) %></td>
                            <td><%= form.get(4) %></td>
                            <td><%= form.get(5) %></td>
                            <td><%= form.get(6) %></td>
                            <td>
                                <a class="btn btn-danger" href="">Delete</a>
                                <a class="btn btn-alert" href="">Edit</a>
                            </td>
                        </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </c:if>

        <c:if test="${empty allFormData}">
            <div class="alert alert-warning" role="alert">
                No form data available in the session.
            </div>
        </c:if>

</body>
</html>
