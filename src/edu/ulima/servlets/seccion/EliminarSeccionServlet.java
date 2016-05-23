package edu.ulima.servlets.seccion;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ulima.beans.SeccionDAO;

@WebServlet("/eliminarSecciones")
public class EliminarSeccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SeccionDAO dao = new SeccionDAO();
		
		int id= Integer.parseInt(request.getParameter("borrar"));
		
		dao.eliminarSeccion(id);
		
		String rpta = "eliminacion.jsp";    		
		RequestDispatcher rd = request.getRequestDispatcher(rpta);
		rd.forward(request, response); 
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
