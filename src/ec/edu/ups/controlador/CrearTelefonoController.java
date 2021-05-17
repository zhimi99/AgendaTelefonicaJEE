package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidades.Telefono;
import ec.edu.ups.entidades.Usuario;


@WebServlet("/CrearTelefonoController")
public class CrearTelefonoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private TelefonoDAO telefonoDao;
	private Telefono telefono;
	UsuarioDAO udao;
	Usuario u;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public CrearTelefonoController() {
    	telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
		telefono = new Telefono();
		udao = DAOFactory.getFactory().getUsuarioDAO();
		u = new Usuario();
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
			String usuCedula = request.getParameter("usuCedula");
			
			//u = usuarioDAO.red
			
			telefono.setCodigo(Integer.parseInt(request.getParameter("codigo")));
			telefono.setNumero(request.getParameter("numero"));
			telefono.setTipo(request.getParameter("tipo"));	
			telefono.setOperadora(request.getParameter("operadora"));
			u.setCedula(request.getParameter("usuCedula"));
			telefono.getUsuCedula().setCedula(request.getParameter("usuCedula"));
			
			telefonoDao.create(telefono);			
			
			url = "HTMLs/crear_Telefono.html";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
    
}
