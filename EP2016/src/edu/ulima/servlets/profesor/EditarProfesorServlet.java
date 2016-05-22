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


@WebServlet("/editarProfesor")
public class EditarProfesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	
	int idgen;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession ses = request.getSession(true);
		
		EstudioDAO estdao = new EstudioDAO();		
		List<Estudio> listaest = estdao.obtenerEstudio();
				
		ProfesorDAO dao = new ProfesorDAO();			
		
		int id = Integer.parseInt(request.getParameter("editar"));
		idgen=id;
		Profesor profe = dao.obtenerDatosProfe(id);
		
		ses.setAttribute("nombre1", profe.getNombres());
		ses.setAttribute("apat", profe.getApellido_paterno());
		ses.setAttribute("amat", profe.getApellido_materno());
		ses.setAttribute("dn", profe.getDni());
		ses.setAttribute("u", profe.getFoto_url());
		ses.setAttribute("listaest", listaest);		
		
		
		ses.setAttribute("listaest", listaest);
		String rpta = "editarProfesor.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(rpta);
		rd.forward(request, response);		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Profesor profe = new Profesor();
		ProfesorDAO dao = new ProfesorDAO();
		
		HttpSession ses = request.getSession(true);	
				
		String nombres = request.getParameter("nombre");
		String apellido_parterno = request.getParameter("aPaterno");
		String apellido_materno = request.getParameter("aMaterno");
		String dni = request.getParameter("dni");
		String foto_url = request.getParameter("fotoUrl");		
		int id_estudio = Integer.parseInt(request.getParameter("selector"));
		
		profe = new Profesor(idgen,nombres, apellido_parterno, apellido_materno, dni, foto_url, id_estudio);
				
		dao.editarProfesor(profe);
		
		response.sendRedirect("/EP2016_v8/obtenerProfesor");
	}
}
