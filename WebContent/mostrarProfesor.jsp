<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar Profesor</title>
</head>
<body>
<div class="main-container">
		<%@include file="nav.jsp"%>
		<div class="row">
			<div class="col-md-3">
				<%@include file="sidebar.jsp"%>
			</div>
			<div class="col-md-9">				
				<div class="contenedor">
					<h3 class="titulo-container">Gestión de Profesores/Mostrar Profesor</h3>
					
					
					<form class="formcontainer" action="editarProfesor" method="post">
					
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>Nombre</label> <input name="nombre" disabled="disabled" class="form-control" type="text" 
									value="${nombre1}">
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label>Apellido Paterno</label> <input disabled="disabled" name="aPaterno" class="form-control"
										type="text" value="${apat}">
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>Apellido Materno</label> <input disabled="disabled" name="aMaterno" class="form-control"
										type="text" value="${amat}">
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>DNI</label> <input disabled="disabled" name="dni" class="form-control" type="text"
									value="${dn}">
								</div>
							</div>
						</div>
						<div class="col-md-4">
								<div class="form-group">
									<label>Centro de estudios</label>
									<input disabled="disabled" name="escuela" class="form-control" type="text"
									value="${escuela}">
								</div>
							</div>
							<br>
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<img src="${u}" border="0">								
								</div>
							</div>
							
						</div>
						
					</form>
				</div>
			</div>
			
		</div>
		<%@include file="footer.jsp"%>
		</div>
		<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		

</body>
</html>