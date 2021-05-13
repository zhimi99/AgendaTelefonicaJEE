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


@WebServlet("/BuscarUsuarioController")
public class BuscarUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDao;
	private Usuario usuario;

	public BuscarUsuarioController() {
		usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		usuario = new Usuario();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = null;
		try {
			String cedula = request.getParameter("cedula");
			usuario = usuarioDao.read(cedula);
			request.setAttribute("usuario", usuario);
			url = "/JSPs/buscar_usuario.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
