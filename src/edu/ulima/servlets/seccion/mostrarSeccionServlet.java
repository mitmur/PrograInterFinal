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
import edu.ulima.beans.Seccion;
import edu.ulima.beans.SeccionDAO;

@WebServlet("/mostrarSeccion")
public class mostrarSeccionServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession ses = request.getSession(true);
		
		SeccionDAO secc = new SeccionDAO();		
			
		
		int id = Integer.parseInt(request.getParameter("visualizar"));
		Seccion aula = secc.obtenerSeccion(id);
		
		ses.setAttribute("cod", aula.getCodigo());
		ses.setAttribute("cur", aula.getNombreCurso());
		ses.setAttribute("prof", aula.getNombreProfe());
	

		String rpta = "mostrarSeccion.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(rpta);
		rd.forward(request, response);		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
