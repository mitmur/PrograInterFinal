<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login ULima</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script type="text/javascript" src="js/facebook.js">  </script>
</head>
<body>
<div>

</div>



	<form action="post" class="form-group" 
	style="border: 5px solid lightgray;
    padding: 40px;
    width: 400px;
    margin: 3% auto;
    font-style: inherit;
    font-family: Calibri;">
    <br>
    	<img src="img/UL_logo.jpg" height=150px width=150px style="margin-left: 30%;">
		<br>
		<br>
		<div>
		  <label for="usr">Usuario:</label>
		  <input type="email" class="form-control" id="usr" placeholder="yourname@email.com" required>
		</div>
		<br>
		<div>
		  <label for="pwd">Contraseña:</label>
		  <input type="password" class="form-control" id="pwd" placeholder="password">
		</div>
		<br>
		<br>
		<input type="button" class="btn btn-primary btn-lg btn-block" style="background-color: green" name="input" value="Ingresar" onclick="ingresar()">
	
		
		<br>
		<br>
	</form>
</body>
</html>