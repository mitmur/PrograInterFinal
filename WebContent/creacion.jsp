<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<title>INICIO</title>
 <script type="text/javascript" src="js/facebook.js">  </script>
</head>
<body>

	<div class="main-container">
	
		<%@include file="nav.jsp"%>
		<div class="row">
			<div class="col-md-3">
				<%@include file="sidebar.jsp"%>
			</div>
			<div class="col-md-9">
				<div class="container">
				<h2 class="titulo-container">Creacion Exitosa</h2>
				</div>
			</div>
		</div>
	</div>
	
	
	<%@include file="footer.jsp"%>
	<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	
		
</body>
</html>