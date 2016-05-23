package edu.ulima.servlets.alumno;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ulima.beans.Alumno;
import edu.ulima.beans.AlumnoDAO;
import edu.ulima.beans.AlumnoSeccion;
import edu.ulima.beans.AlumnoSeccionDAO;
import edu.ulima.beans.Seccion;
import edu.ulima.beans.SeccionDAO;

@WebServlet("/asignarAlumno")
public class AsignarAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	int idSecc;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession ses = request.getSession(true);
				
		SeccionDAO dao = new SeccionDAO();			
		
		int id = Integer.parseInt(request.getParameter("alumnos"));
		idSecc=id;
		Seccion secc = dao.obtenerSeccion(id);
		
		AlumnoDAO daoalumno = new AlumnoDAO();
		List<Alumno> listaa = daoalumno.obtenerAlumnos();
		
		ses.setAttribute("listaa", listaa);
		
		
		ses.setAttribute("codsecasignar", secc.getCodigo());
		ses.setAttribute("cursoasignar", secc.getNombreCurso());
		ses.setAttribute("profeasignar", secc.getNombreProfe());
		
		
		String rpta = "asignarAlumnos.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(rpta);
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession ses = request.getSession(true);
		AlumnoSeccionDAO dao = new AlumnoSeccionDAO();
		
				
		int id_alumno = Integer.parseInt(request.getParameter("checksec"));
		
		
	
        	AlumnoSeccion alsec = new AlumnoSeccion(id_alumno, idSecc);
    		
    		dao.agregarAlumnoSeccion(alsec);    		
        	
        	ses.removeAttribute("lsec");    	
        	
        	String rpta = "creacion.jsp";    		
    		RequestDispatcher rd = request.getRequestDispatcher(rpta);
    		rd.forward(request, response); 
        
		
	}

}
