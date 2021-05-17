package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.entidades.Telefono;

/**
 * Servlet implementation class ListarTelefonoController
 */
@WebServlet("/ListarTelefonoController")
public class ListarTelefonoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TelefonoDAO telefonoDAO;
	private List<Telefono> listaTelefono;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTelefonoController() {
        super();
        // TODO Auto-generated constructor stub
        telefonoDAO = DAOFactory.getFactory().getTelefonoDAO();
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String url = null;
		try {
			
			listaTelefono = telefonoDAO.find();
			System.out.println("Tamaño de la lista recuperada: " + listaTelefono.size());
			request.setAttribute("telefonos", listaTelefono);
			url = "/JSPs/listar_persona.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
