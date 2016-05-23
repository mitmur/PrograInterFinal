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
					
					<form class="formcontainer" action="asignarAlumno" method="post">
					
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>Codigo de Sección</label><input name="codsec" disabled="disabled" type="text"  class="form-control"
									value="${codsecasignar}" >
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label>Curso</label><input name="curso" type="text" disabled="disabled" class="form-control" 
									value="${cursoasignar}">
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>Profesor</label><input name="profe" type="text" disabled="disabled" class="form-control"
									value="${profeasignar}">
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
								<c:forEach var="x"  items="${sessionScope.listaa}">
								<tr>
									<td><c:out value="${x.codigo}" /></td>
									<td><c:out value="${x.apellido_paterno}" /></td>
									<td><c:out value="${x.apellido_materno}" /></td>
									<td><c:out value="${x.nombres}" /></td>
									<td>
									
  									<input value="<c:out value='${x.id}' />" type="checkbox" name="checksec" ><br>
  																
        							</td>
								</tr>
								</c:forEach>
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