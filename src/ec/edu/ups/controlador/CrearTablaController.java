package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;

/**
 * Servlet implementation class CrearTablaController
 */
@WebServlet("/CrearTablaController")
public class CrearTablaController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearTablaController() {
    	usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = null;
		try {
			usuarioDao.createTable();
			url = "/index.html";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
