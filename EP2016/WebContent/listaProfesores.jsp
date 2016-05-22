<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<title>Profesores</title>
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
					<h3 class="titulo-container">Gestión de Profesores/Ver lista de Profesores</h3>
					<form class="formcontainer">
						<table class="table">
							<thead>
								<tr>
									<th>Apellido Paterno</th>
									<th>Apellido Materno</th>
									<th>Nombres</th>
									<th>DNI</th>
									<th>Estudios</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="x"  items="${sessionScope.listap}">
								<tr>
									<td><c:out value="${x.apellido_paterno}" /></td>
									<td><c:out value="${x.apellido_materno}" /></td>
									<td><c:out value="${x.nombres}"/></td>
									<td><c:out value="${x.dni}" /></td>
									<td><c:out value="${x.nombreEstudios}" /></td>
									<td>										
										<a href="editarProfesor" ><button name="editar" value="<c:out value='${x.id}'/>" type="submit" formmethod="get" formaction="editarProfesor" class="btn btn-default btn-sm">
          								<span class="glyphicon glyphicon-pencil"></span> 
        								</button></a>
        								<a href="#" ><button name="visualizar" value="${x.dni}" type="button" class="btn btn-default btn-sm">
          								<span class="glyphicon glyphicon-zoom-in"></span>    
          								</button> </a>    								
        								<a href="eliminarProfesor" ><button name="borrar" value="<c:out value='${x.id}'/>" type="submit" formmethod="get" formaction="eliminarProfesor" class="btn btn-default btn-sm">
          								<span class="glyphicon glyphicon-remove"></span> 
        								</button></a>
        							</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
						</form>
						<div class="col-md-4">						
								<div class="form-group">
								<a href="obtenerEstudios" class="btn btn-primary btn-success">
								<span class="glyphicon glyphicon-plus"></span> Agregar Registro</a>
										</div>
								</div>
							</div>
				</div>
			</div>
		</div>
		<%@include file="footer.jsp"%>
		<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>

