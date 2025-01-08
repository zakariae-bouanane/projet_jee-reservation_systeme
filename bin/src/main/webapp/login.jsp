
<!DOCTYPE html>
<html>
<head>
	<title>Authentification</title>
	<link rel="stylesheet" type="text/css" href="assets/css/login.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="data:image/svg+xml,<svg xmlns=%22http://www.w3.org/2000/svg%22 viewBox=%220 0 100 100%22><text y=%22.9em%22 font-size=%2280%22>👁</text></svg>">
</head>
<body>
	
	<img class="wave" src="img/medical-5459630_1280.png">

	<div class="container">
		
		<div class="login-content">
			
			<form action="login" method="POST" >
				<img src="img/boy-2027768_1280.png" alt="img">
				<img src="img/cartoon-2027771_1280.png" alt="img">
				<h3 class="title">Authentification</h3>
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-user"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>username</h5>
           		   		<input type="text" name="username" class="input">
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
            	<a href="#">mot de passe oublie ?</a>
            	<input type="submit" name="connexion" class="btn" value="se connecter" required>
            </form>
        </div>		
    </div>
    <script type="text/javascript" src="assets/js/login3.js"></script>
	
</body>
</html>