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
					<h3 class="titulo-container">Gestión de Asignaturas/Ver Lista de Secciones</h3>
					<form class="formcontainer">
						<table class="table">
							<thead>
								<tr>
									<th>Codigo</th>
									<th>Nombre Curso</th>
									<th>Carrera</th>
									<th>Alumnos Matriculados</th>
									<th>Acciones</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="x" items="${sessionScope.listasec}">						
								<tr>
									<td><c:out value="${x.codigo}" /></td>
									<td><c:out value="${x.nombreCurso}" /></td>
									<td><c:out value="${x.nombreEscuela}" /></td>			
									<td></td>						
									<td>										
										<a href="#" ><button name="editar" value="<c:out value='${x.id}'/>" type="submit" formmethod="get" formaction="#" class="btn btn-default btn-sm">
          								<span class="glyphicon glyphicon-pencil"></span> 
        								</button></a>
        								
        								<a href="#" ><button name="visualizar" value="<c:out value='${x.id}'/>" type="submit" formmethod="get" formaction="#" class="btn btn-default btn-sm">
          								<span class="glyphicon glyphicon-zoom-in"></span>    
          								</button></a>  
          								  	
          								<a href="#" ><button name="lista" value="<c:out value='${x.id}'/>" type="submit" formmethod="get" formaction="#"  class="btn btn-default btn-sm">
          								<span class="glyphicon glyphicon-th-list"></span> 
        								</button></a>
        								
        								<a href="asignarAlumno"><button name="alumnos" value="<c:out value='${x.id}'/>" type="submit" formmethod="get" formaction="#"  class="btn btn-default btn-sm">
          								<span class="glyphicon glyphicon-user"></span> 
        								</button></a>	
        														
        								<a href="#" ><button name="borrar" value="<c:out value='${x.id}'/>" type="submit" formmethod="get" formaction="#" class="btn btn-default btn-sm">
          								<span class="glyphicon glyphicon-remove"></span> 
        								</button></a>
        							</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
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
		<%@include file="footer.jsp"%>
		<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>