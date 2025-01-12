<html class="no-js" lang="en">
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
    <link rel="icon" href="../img/favicon.png">
    
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
    <section class="appointment">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="section-title">
                        <h2>We Are Always Ready to Help You. Book An Appointment</h2>
                        <img src="../img/section-img.png" alt="#">
                            <% 
                                String successMessage = request.getParameter("success");
                                if (successMessage != null) {
                            %>
                                <h2 style="color: green;"><%= successMessage %> </h2>
                            <% 
                                } 
                            %>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-12 col-12">
<% 
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
            <div style="color: red; font-size: 14px; padding: 10px; border: 1px solid red; background-color: #f8d7da;">
                <%= errorMessage %>
            </div>
        <% 
            }
            String exceptionMessage = (String) request.getAttribute("exceptionMessage");
            if (exceptionMessage != null) {
        %>
            <div style="color: red; font-size: 14px; padding: 10px; border: 1px solid red; background-color: #f8d7da;">
                <strong>Erreur technique : </strong><%= exceptionMessage %>
            </div>
        <% 
            }
        %>

                    <form class="form" method="post" action="../InfermierAppointment">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-12">
                                <div class="form-group">
                                    <input name="name" type="text" placeholder="Name">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-12">
                                <div class="form-group">
                                    <input name="email" type="email" placeholder="Email">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-12">
                                <div class="form-group">
                                    <input name="phone" type="text" placeholder="Phone">
                                </div>
                            </div>

                            <div class="col-lg-6 col-md-6 col-12">
                                <div class="form-group">
                                    <div class="nice-select form-control wide" tabindex="0"><span class="current">Department</span>
                                        <select class="" name="department" id="">
                                            <option value="null" selected>Department</option>
                                            <option value="Cardiac Clini">Cardiac Clinic</option>
                                            <option value="Neurology">Neurology</option>
                                            <option value="Dentistry">Dentistry</option>
                                            <option value="Gastroenterology">Gastroenterology</option>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-6 col-md-6 col-12">
                                <div class="form-group">
                                    <div class="nice-select form-control wide" tabindex="0"><span class="current">Doctor</span>
                                        <select class="" name="doctor" id="">
                                            <option value="null" selected>Doctor</option>
                                            <option value="Dr. Akther Hossain">Dr. Akther Hossain</option>
                                            <option value="Dr. Dery Alex">Dr. Dery Alex</option>
                                            <option value="Dr. Jovis Karon">Dr. Jovis Karon</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                    
                            <div class="col-lg-6 col-md-6 col-12">
                                <div class="form-group">
                                    <input type="date" name="date" placeholder="Date" id="datepicker">
                                </div>
                            </div>
                            <div class="col-lg-12 col-md-12 col-12">
                                <div class="form-group">
                                    <textarea name="message" placeholder="Write Your Message Here....."></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-5 col-md-4 col-12">
                                <div class="form-group">
                                    <div class="button">
                                        <button type="submit" class="btn">Book An Appointment</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-lg-6 col-md-12 ">
                    <div class="appointment-image">
                        <img src="../img/contact-img.png" alt="#">
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- End Appointment -->
</body>
    

</html>