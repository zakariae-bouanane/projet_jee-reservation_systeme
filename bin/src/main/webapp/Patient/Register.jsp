<!DOCTYPE html>
<html>

<head>
    <title>Register Page</title>
    <link rel="stylesheet" type="text/css" href="/gestion_reservation/assets/css/login.css">
    <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
    <style>
        .alert {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
        }

        .alert-danger {
            color: #721c24;
            background-color: #f8d7da;
            border-color: #f5c6cb;
        }

        .form-container {
            max-width: 500px;
            background-color: #ffffff;
            /* White background for form */
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #004085;
            /* Dark blue color */
        }

        .form-group label {
            font-weight: bold;
            color: #004085;
        }

        .btn-custom {
            background-color: #004085;
            color: white;
        }

        .btn-custom:hover {
            background-color: #002c4a;
        }
    </style>
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon"
        href="data:image/svg+xml,<svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 100 100'><text y='0.9em' font-size='80'>👁</text></svg>">

        <style>
            label {
                color: white !important;
            }
        </style>



</head>

<body>

    <img class="wave" src="/gestion_reservation/img/medical-5459630_1280.png">

    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="login-content bg-light p-4 rounded shadow" style="width: 100%; max-width: 500px;">
            <form action="/gestion_reservation/Register" method="POST">
                <!-- Form Images -->
                <div class="text-center mb-4">
                    <img src="/gestion_reservation/img/boy-2027768_1280.png" alt="img" class="img-fluid mb-2" style="height: 60px;">
                    <img src="/gestion_reservation/img/cartoon-2027771_1280.png" alt="img" class="img-fluid mb-2" style="height: 60px;">
                </div>
                
                <!-- Form Title -->
                <h3 class="title text-center mb-4">Register</h3>
    
                <!-- Error Message -->
                <% String error = (String) request.getAttribute("error");
                    if (error != null && !error.isEmpty()) { %>
                    <div class="alert alert-danger text-center" role="alert">
                        <%= error %>
                    </div>
                <% } %>
    
                <!-- Form Fields -->
                <div class="mb-3">
                    <label for="name" class="form-label text-white">Name:</label></br>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
    
                <div class="mb-3">
                    <label for="telephone" class="form-label text-white">Telephone:</label></br>
                    <input type="text" class="form-control" id="telephone" name="telephone" required>
                </div>
    
                <div class="mb-3">
                    <label for="email" class="form-label text-white">Email:</label></br>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
    
                <div class="mb-3 ">
                    <label for="password" class="form-label text-white">Password:</label></br>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>
    
                <div class="mb-3">
                    <label for="dateDeNaissance" class="form-label text-white">Date of Birth:</label></br>
                    <input type="date" class="form-control" id="dateDeNaissance" name="dateDeNaissance" required>
                </div>
    
                <!-- Submit Button -->
                <div class="text-center">
                    <button type="submit" class="btn btn-primary w-100">Register</button>
                </div>
            </form>
        </div>
    </div>
    


    <script type="text/javascript" src="/gestion_reservation/assets/js/login3.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
</body>

</html>