package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidades.Telefono;
import ec.edu.ups.entidades.Usuario;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDao;
	private Usuario usuario;
	private TelefonoDAO telefonoDAO;
	private Telefono telefono;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
    	usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
		usuario = new Usuario();
		telefonoDAO = DAOFactory.getFactory().getTelefonoDAO();
		telefono = new Telefono();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = null;

		int num = 0;
		response.setContentType("text/html");

		try {
			
			String mail = String.valueOf(request.getParameter("mail"));
			String pass = String.valueOf(request.getParameter("pass"));

			System.out.println("Iniciando...");
			HttpSession session = request.getSession(true);
			List<Usuario> list = new ArrayList<Usuario>();
			list = usuarioDao.find();
			
			System.out.println("Listado " + list.toString());
			url = "/index.html";
			if (list != null) {
				for (Usuario usuario : list) {
					System.out.println("Usuario allado" + usuario.toString());
					System.out.println("Datos ingresados email: " + mail + " pass: " + pass);
					System.out.println(
							"Datos recuperados email: " + usuario.getCorreo() + " pass: " + usuario.getClave());

					if (usuario.getClave().equals(pass) && usuario.getCorreo().equals(mail)) {
						System.out.println("Logiado");
						session.setAttribute("usuario", usuario);

						if (session.isNew()) {
							session.setAttribute("accesos", 1);
						} else {
							session.setAttribute("accesos", num + 1);
						}
						System.out.println("Iniciando session");
						request.setAttribute("usuario", usuario);
						List<Telefono> telns = new ArrayList<Telefono>();
						for (Telefono telefono : telefonoDAO.find()) {
							if (telefono.getUsuCedula().getCedula().equals(usuario.getCedula())) {
								telns.add(telefono);
							}
						}
						request.setAttribute("telefonos", telns);

						url = "/JSPs/inicio_usuario.jsp";
						System.out.println(url);
						break;
						// response.sendRedirect(url);
					}else {
						session.invalidate();
						System.out.println("Usuario o clave incorrecta.");
						url = "/index.html";
				}
			} 
			}else {
				session.invalidate();
				System.out.println("Usuario o clave incorrecta.");
				url = "/index.html";
		}

		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
		
		
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		System.out.println("Conculta. " + request);
		if (request.getParameter("logout") != null) {
			session.invalidate();
			response.sendRedirect("/AgendaTelefonicaJEE/HTMLs/login.html");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    
}
