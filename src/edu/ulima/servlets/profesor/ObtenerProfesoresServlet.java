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


@WebServlet("/obtenerProfesor")
public class ObtenerProfesoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ObtenerProfesoresServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession ses = request.getSession(true);
		
		ProfesorDAO dao = new ProfesorDAO();
		List<Profesor> listap = dao.obtenerProfesores();
		
		
				
		
		ses.setAttribute("listap", listap);
		String rpta = "listaProfesores.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(rpta);
		rd.forward(request, response);
	}

	
	

}
