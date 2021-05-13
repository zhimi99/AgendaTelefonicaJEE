package ec.edu.ups.jdbc;
	
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidades.Usuario;
	 
public class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario, String> implements UsuarioDAO {

	
		public void createTable() {
			conexion.update("DROP TABLE IF EXISTS Usuario");
			conexion.update("CREATE TABLE Usuario (" + "CEDULA INT NOT NULL, "
					+ "NOMBRE VARCHAR(255), APELLIDO VARCHAR(255), CORREO VARCHAR(255), CLAVE VARCHAR(255)" + ", PRIMARY KEY (CEDULA))");
		}
		
		
		public void create(Usuario usuario) {
			conexion.update("INSERT Usuario VALUES (" + usuario.getCedula() + ",'" +usuario.getNombre() + "','" + usuario.getApellido() + "', '"
					+ usuario.getCorreo() + "','" + usuario.getClave() + "')");
		}
		
		
		public Usuario read(String cedula) {
			Usuario usuario = null;
			ResultSet rs = conexion.query("SELECT * FROM usuario WHERE cedula=" + cedula);
			try {
				if (rs != null && rs.next()) {
					usuario = new Usuario(rs.getString("cedula"), rs.getString("nombre"),
							rs.getString("apellido"),rs.getString("correo"),rs.getString("clave"));
				}
			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBCUsuarioDAO:read): " + e.getMessage());
			}

			return usuario;
		}
		
		
		public void update(Usuario usuario) {
			conexion.update("UPDATE Usuario SET cedula = '" + usuario.getCedula() + "', nombre = '" + usuario.getNombre()
					+ "', apellido = '" + usuario.getApellido() + "', correo = '" + usuario.getCorreo() + "', clave = '" + usuario.getClave() +"' WHERE cedula = " + usuario.getCedula());

		}

		
		public void delete(Usuario usuario) {
			conexion.update("DELETE FROM Usuario WHERE cedula = " + usuario.getCedula());

		}

		public List<Usuario> find() {
			List<Usuario> list = new ArrayList<Usuario>();
			ResultSet rs = conexion.query("SELECT * FROM Usuario");
			try {
				while (rs.next()) {
					list.add(new Usuario(rs.getString("cedula"), rs.getString("nombre"),
							rs.getString("apellido"),rs.getString("correo"),rs.getString("clave")));
				}
				
			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBCUsuarioDAO:find): " + e.getMessage());
			}
			return list;
		}
	}

