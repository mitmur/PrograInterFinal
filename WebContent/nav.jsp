<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	  <div id="fb-root"></div>
 <script type="text/javascript" src="js/facebook.js">  </script>
	
<nav class="navbar navbar-default">
	<div class="container-fuid">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.jsp">
        		<img src="img/UL_logo.jpg" style="height: 30px;">
     		</a>
		</div>
		<ul class="nav navbar-nav">
     		<li class="active"><a href="index.jsp">Gestion Académica</a></li>
      		<li><a href="#">Gestión de Eventos</a></li>
      		<li><a href="#">Gestión Contable</a></li>       		
    	</ul>
    	<ul class="nav navbar-nav navbar-right">
    		<li><span class="glyphicon glyphicon-log-out"><a href="login.jsp" onclick="logout();">Cerrar Sesion</a></span></li>
    	</ul>
	</div>
</nav>