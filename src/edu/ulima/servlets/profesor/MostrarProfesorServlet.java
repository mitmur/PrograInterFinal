package edu.ulima.servlets.profesor;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ulima.beans.Estudio;
import edu.ulima.beans.EstudioDAO;
import edu.ulima.beans.Profesor;
import edu.ulima.beans.ProfesorDAO;


@WebServlet("/mostrarProfesor")
public class MostrarProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession ses = request.getSession(true);
		
		EstudioDAO estdao = new EstudioDAO();		
		List<Estudio> listaest = estdao.obtenerEstudio();
				
		ProfesorDAO dao = new ProfesorDAO();			
		
		int id = Integer.parseInt(request.getParameter("visualizar"));
		Profesor profe = dao.obtenerDatosProfe(id);
		
		ses.setAttribute("nombre1", profe.getNombres());
		ses.setAttribute("apat", profe.getApellido_paterno());
		ses.setAttribute("amat", profe.getApellido_materno());
		ses.setAttribute("dn", profe.getDni());
		ses.setAttribute("u", profe.getFoto_url());
		ses.setAttribute("escuela", profe.getNombreEstudios());		
		
		
		ses.setAttribute("listaest", listaest);
		String rpta = "mostrarProfesor.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(rpta);
		rd.forward(request, response);		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	

}
