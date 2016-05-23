<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Profesor</title>
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
					<h3 class="titulo-container">Gestión de Profesores/Agregar Profesor</h3>
					<h4 class="titulo-container">Editar Profesor</h4>
					
					<form class="formcontainer" action="editarProfesor" method="post">
					
						<div class="row">
							<div class="col-md-3">
								<div class="form-group">
									<label>Nombre</label> <input name="nombre" class="form-control" type="text" 
									value="${nombre1}">
								</div>
							</div>

							<div class="col-md-3">
								<div class="form-group">
									<label>Apellido Paterno</label> <input name="aPaterno" class="form-control"
										type="text" value="${apat}">
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>Apellido Materno</label> <input name="aMaterno" class="form-control"
										type="text" value="${amat}">
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									<label>DNI</label> <input name="dni" class="form-control" type="text"
									value="${dn}">
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-4">
								<div class="form-group">
									<label>Url foto</label> <input name="fotoUrl" class="form-control" type="text"
									value="${u}">
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