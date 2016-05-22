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


@WebServlet("/eliminarProfesor")
public class EliminarProfesorServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Profesor> lprof= null;
		
		HttpSession ses = request.getSession(true);
		ProfesorDAO dao = new ProfesorDAO();
		
		int id = Integer.parseInt(request.getParameter("borrar"));
				
		dao.eliminarProfesor(id);
		
						
		response.sendRedirect("/EP2016_v8/obtenerProfesor");
	}
}