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
<%--script type="text/javascript">	alert(<%String txt = (String) request.getAttribute("alertMsg");%>);</script>--%>
	<div class="main-container">
		<%@include file="nav.jsp"%>
		<div class="row">
			<div class="col-md-3">
				<%@include file="sidebar.jsp"%>
			</div>
			<div class="col-md-9">				
				<div class="contenedor">
					<h3 class="titulo-container">Gestión de Profesores/Agregar Profesor</h3>
					
					<form class="formcontainer" action="agregarProfesor" method="post">
					
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>Nombre</label> <input name="nombre" class="form-control" type="text"
										placeholder="Nombre">
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label>Apellido Paterno</label> <input name="aPaterno" class="form-control"
										type="text" placeholder="Apellido Paterno">
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>Apellido Materno</label> <input name="aMaterno" class="form-control"
										type="text" placeholder="Apellido Materno">
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>DNI</label> <input name="dni" class="form-control" type="text"
										placeholder="DNI">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label>Url foto</label> <input name="fotoUrl" class="form-control" type="text"
										placeholder="Url foot">
								</div>
							</div>
							<div class="col-md-4">
								<div class="form-group">
									<label>Centro de estudios</label>
									<select class="form-control" name="selector">										
										<c:forEach var="x" items="${sessionScope.listaest}">
											<option value="<c:out value='${x.id}'/>"> <c:out value="${x.nombre}"/> - <c:out value="${x.mencion}"/></option>											
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-md-4">
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
		<%@include file="footer.jsp"%>
		</div>
		<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		
</body>
</html>