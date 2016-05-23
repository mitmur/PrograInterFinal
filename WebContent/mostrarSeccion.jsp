<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostrar Seccion</title>
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
					<h3 class="titulo-container">Gestión de Secciones/Mostrar Seccion</h3>
					
					
					<form class="formcontainer" action="mostrarSeccion" method="post">
					
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>Codigo</label> <input name="codigo" disabled="disabled" class="form-control" type="text" 
									value="${cod}">
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label>Curso</label> <input disabled="disabled" name="curso" class="form-control"
										type="text" value="${cur}">
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>Profesor</label> <input disabled="disabled" name="profesor" class="form-control"
										type="text" value="${prof}">
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