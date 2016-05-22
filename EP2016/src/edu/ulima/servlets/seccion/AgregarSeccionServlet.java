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


@WebServlet("/agregarSeccion")
public class AgregarSeccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Seccion> lsec= null;
		
		HttpSession ses = request.getSession(true);
		SeccionDAO dao = new SeccionDAO();
		
		int codigo = Integer.parseInt(request.getParameter("codigo"));		
		int curso = Integer.parseInt(request.getParameter("curso"));
		int profesor = Integer.parseInt(request.getParameter("profesor"));
		
		if (dao.validarCOD(codigo)==true) {   
			//request.setAttribute("alertMsg","DNI ya ha sido registrado" );
			//response.sendRedirect("/obtenerEstudios");
			String rpta = "index.jsp";    		
    		RequestDispatcher rd = request.getRequestDispatcher(rpta);
    		rd.forward(request, response);           
        } else {    
        	Seccion sec = new Seccion(codigo, curso, profesor);
    		
    		dao.grabarSecciones(sec);    		
        	
        	ses.removeAttribute("lsec");    		
    		
    		
    		//request.setAttribute("successMsg", "Se ingreso al Profesor con exito");
        	response.sendRedirect("/EP2016_v5/obtenerSecciones");
        }			
	}

}
