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

@WebServlet("/obtenerEstudios")
public class ObtenerEstudioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ObtenerEstudioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession ses = request.getSession(true);
		
		
		
		EstudioDAO estdao = new EstudioDAO();		
		List<Estudio> listaest = estdao.obtenerEstudio();
		
		
		ses.setAttribute("listaest", listaest);		
		String rpta = "agregarProfesor.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(rpta);
		rd.forward(request, response);
	}

	

}
