<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<h3 class="titulo-container">Gestión de Asignaturas/Agregar
						Seccion</h3>
					<form class="formcontainer" action="agregarSeccion" method="post">
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>Codigo</label> <input name="codigo" class="form-control" type="text"
										placeholder="Codigo">
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label>Curso</label>
									<select class="form-control" name="curso">										
										<c:forEach var="x" items="${sessionScope.listacurso}">
											<option value="<c:out value='${x.id}'/>"> <c:out value="${x.nombre}"/></option>											
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label>Profesor</label>
									<select class="form-control" name="profesor">										
										<c:forEach var="x" items="${sessionScope.listaProfesor}">
											<option value="<c:out value='${x.id}'/>"> <c:out value="${x.nombres}"/> <c:out value="${x.apellido_paterno}"/> <c:out value="${x.apellido_materno}"/></option>											
										</c:forEach>
									</select>
								</div>
							</div>						
						</div>
						<div class="row">
								<div class="col-md-3">
								<div class="form-group">
									<input class="btn btn-success boton-formulario" type="submit"
										value="Guardar cambios">
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		</div>
		<%@include file="footer.jsp"%>
		<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>