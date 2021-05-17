package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidades.Usuario;


@WebServlet("/CrearUsuarioController")
public class CrearUsuarioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDao;
	private Usuario usuario;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuarioController() {
    	usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		usuario = new Usuario();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String url = null;
		try {			
			usuario.setCedula(request.getParameter("cedula"));
			usuario.setNombre(request.getParameter("nombre"));
			usuario.setApellido(request.getParameter("apellido"));	
			usuario.setCorreo(request.getParameter("correo"));
			usuario.setClave(request.getParameter("clave"));
			usuarioDao.create(usuario);			
			
			url = "HTMLs/crear_usuario.html";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}

}
