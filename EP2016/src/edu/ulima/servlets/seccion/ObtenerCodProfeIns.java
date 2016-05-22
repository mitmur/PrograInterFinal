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

import edu.ulima.beans.Curso;
import edu.ulima.beans.CursoDAO;
import edu.ulima.beans.Profesor;
import edu.ulima.beans.ProfesorDAO;


@WebServlet("/obtenerCodProfe")
public class ObtenerCodProfeIns extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ses = request.getSession(true);	
		
		ProfesorDAO profedao = new ProfesorDAO();
		CursoDAO cursDao = new CursoDAO();
		
		List<Profesor> listaprofe = profedao.obtenerProfesores();
		List<Curso> listacurso = cursDao.obtenerCurso();		
		
		ses.setAttribute("listacurso", listacurso);	
		ses.setAttribute("listaProfesor", listaprofe);
		
		String rpta = "agregarSeccion.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(rpta);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
