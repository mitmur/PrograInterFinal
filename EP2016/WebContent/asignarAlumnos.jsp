<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<title>INICIO</title>
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
					<h3 class="titulo-container">Gestión de Asignaturas/Asignar alumnos a Sección</h3>
					<form class="formcontainer">
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>Codigo de Sección</label> <input class="form-control" type="text"
										value="Codigo">
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label>Curso</label> <input class="form-control"
										type="text" value="Curso">
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>Profesor</label> <input class="form-control"
										type="text" value="Profesor">
								</div>
							</div>
							
						</div>
						<div class="row">
							<table class="table">
								<thead>
									<tr>
										<th>Codigo</th>
										<th>Apellido Paterno</th>
										<th>Apellido Materno</th>
										<th>Nombre</th>
										<th>Pertenece</th>
									</tr>
								</thead>
								<tbody>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td>
										<input type="checkbox" name="" value=""><br>
        							</td>
								</tr>
								</tbody>
								</table>
							</div>							
						<div class="col-md-4">
								<div class="form-group">
									<input class="btn btn-success boton-formulario" type="submit"
										value="Guardar cambios">
								</div>
					</div>
					</form>
				</div>
			</div>
		</div>
		</div>

		<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>