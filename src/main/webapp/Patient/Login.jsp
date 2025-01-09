
<!DOCTYPE html>
<html>
<head>
	<title>Authentification</title>
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
    </style>
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="data:image/svg+xml,<svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 100 100'><text y='0.9em' font-size='80'>👁</text></svg>">
	



</head>
<body>
	
	<img class="wave" src="/gestion_reservation/img/medical-5459630_1280.png">

	<div class="container">
		
		<div class="login-content">
			
			<form action="/gestion_reservation/LoginPatient" method="POST" >
				<img src="/gestion_reservation/img/boy-2027768_1280.png" alt="img">
				<img src="/gestion_reservation/img/cartoon-2027771_1280.png" alt="img">
				<h3 class="title">Authentification</h3>

  <!-- Affichage du message d'erreur -->
                <%
                    String error = (String) request.getAttribute("error");
                    if (error != null && !error.isEmpty()) {
                %>
                    <div class="alert alert-danger" role="alert">
                        <%= error %>
                    </div>
                <% } %>





           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-user"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Email</h5>
           		   		<input type="text" name="email" class="input">
           		   </div>
           		</div>
           		<div class="input-div pass">
           		   <div class="i"> 
           		    	<i class="fas fa-lock"></i>
           		   </div>
           		   <div class="div">
           		    	<h5>Mot de passe</h5>
           		    	<input type="password" name="password" class="input" required>
            	   </div>
            	</div>
            	<input type="submit" name="connexion" class="btn" value="se connecter" required>
            </form>
        </div>		
    </div>
    <script type="text/javascript" src="/gestion_reservation/assets/js/login3.js"></script>
	
</body>
</html>