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
import edu.ulima.beans.Seccion;
import edu.ulima.beans.SeccionDAO;

@WebServlet("/editarSeccion")
public class EditarSeccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	int idSecc;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ses = request.getSession(true);	
		
		ProfesorDAO profedao = new ProfesorDAO();
		CursoDAO cursDao = new CursoDAO();
		SeccionDAO seccdao = new SeccionDAO();
		
		List<Profesor> listaprofe = profedao.obtenerProfesores();
		List<Curso> listacurso = cursDao.obtenerCurso();
		
		int id=Integer.parseInt(request.getParameter("editar"));
		idSecc=id;
		Seccion secc = seccdao.obtenerSeccion(id);
		
		ses.setAttribute("codigo", secc.getCodigo());
		ses.setAttribute("listacurso", listacurso);	
		ses.setAttribute("listaProfesor", listaprofe);
		
		String rpta = "editarSeccion.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(rpta);
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession ses = request.getSession(true);
		SeccionDAO dao = new SeccionDAO();
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));		
		int curso = Integer.parseInt(request.getParameter("curso"));
		int profesor = Integer.parseInt(request.getParameter("profesor"));
		
		
		if (dao.validarCOD(codigo)==true) {   
							
			String rpta = "error.jsp";    		
    		RequestDispatcher rd = request.getRequestDispatcher(rpta);
    		rd.forward(request, response);           
        } else {   
        
        	Seccion sec = new Seccion(idSecc,codigo, curso, profesor);
    		
    		dao.editarSeccion(sec);    		
        	
        	ses.removeAttribute("lsec");    		
    		
    		
        	String rpta = "edicion.jsp";    		
    		RequestDispatcher rd = request.getRequestDispatcher(rpta);
    		rd.forward(request, response); 
        }			
	}		
	}
