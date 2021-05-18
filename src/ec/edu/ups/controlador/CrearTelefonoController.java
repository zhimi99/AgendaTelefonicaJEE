package ec.edu.ups.controlador;

import java.io.IOException;
import java.io.PrintWriter;

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
	private UsuarioDAO UsuarioDAO;
	private Usuario usuario;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public CrearTelefonoController() {
    	telefonoDao = DAOFactory.getFactory().getTelefonoDAO();
		telefono = new Telefono();
		UsuarioDAO = DAOFactory.getFactory().getUsuarioDAO();
		usuario = new Usuario();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		try {
			System.out.println("Guardando...");
			String ced = request.getParameter("usuario");
			System.out.println("Cedula: "+ced);
			usuario = UsuarioDAO.read(ced);
			System.out.println("Usuario: "+usuario.toString());
			if (usuario!=null) {
				String numero = request.getParameter("numero");
				String tipo = request.getParameter("tipo");
				String operadora = request.getParameter("operadora");
				telefono.setCodigo(0);
				telefono.setNumero(numero);
				telefono.setTipo(tipo);
				telefono.setOperadora(operadora);
				telefono.setUsuCedula(usuario);
				telefonoDao.create(telefono);
				PrintWriter out = response.getWriter();
				out.println("<p>Telefono agregado correctamente</p>");
				out.println("<a href='/AgendaTelefonicaJEE/JSPs/crearTelefono.jsp'>Volver</a>");
				out.println("</body></html>");
				
			}else {
				System.out.println("Usuario no encontrado.");
				url = "/JSPs/error.jsp";
			}
		} catch (Exception e) {
			System.out.println("Error crear telefono=> "+e.getMessage());
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url);
	}
    
}
