package edu.ulima.servlets.seccion;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ulima.beans.Profesor;
import edu.ulima.beans.ProfesorDAO;
import edu.ulima.beans.Seccion;
import edu.ulima.beans.SeccionDAO;

@WebServlet("/obtenerSecciones")
public class ObtenerSeccionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ses = request.getSession(true);
		
		SeccionDAO dao = new SeccionDAO();
		List<Seccion> listasec = dao.obtenerSecciones();
		
		ses.setAttribute("listasec", listasec);
		String rpta = "listaSecciones.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(rpta);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
