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

import edu.ulima.beans.Profesor;
import edu.ulima.beans.ProfesorDAO;


@WebServlet("/agregarProfesor")
public class AgregarProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession ses = request.getSession(true);
		ProfesorDAO dao = new ProfesorDAO();
		
		String nombres = request.getParameter("nombre");		
		String apellido_parterno = request.getParameter("aPaterno");
		String apellido_materno = request.getParameter("aMaterno");
		String dni = request.getParameter("dni");
		String foto_url = request.getParameter("fotoUrl");
		int id_estudio = Integer.parseInt(request.getParameter("selector"));
		
		if (dao.validarDNI(dni)==true) {   
			request.setAttribute("dnierror","dnierror" );
			
			String rpta = "error.jsp";    		
    		RequestDispatcher rd = request.getRequestDispatcher(rpta);
    		rd.forward(request, response);           
        } else {    
        	Profesor profe = new Profesor( nombres, apellido_parterno, apellido_materno, dni, foto_url, id_estudio);
    		
    		dao.grabarProfesor(profe);
    		
    		ses.removeAttribute("lprof");    
    		
    		String rpta = "creacion.jsp";    		
    		RequestDispatcher rd = request.getRequestDispatcher(rpta);
    		rd.forward(request, response); 
        }							
	}
}
