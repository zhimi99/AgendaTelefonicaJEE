package ec.edu.ups.jdbc;
	
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidades.Usuario;
	 
public class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario, Integer> implements UsuarioDAO {

		@Override
		public void createTable() {
			conexion.update("DROP TABLE IF EXISTS Persona");
			conexion.update("CREATE TABLE Persona (" + "ID INT NOT NULL, " + "CEDULA VARCHAR(10), "
					+ "NOMBRE VARCHAR(255), APELLIDO VARCHAR(255)" + ", PRIMARY KEY (ID))");
		}

		@Override
		public void create(Usuario usuario) {
			conexion.update("INSERT Persona VALUES (" + usuario.getNombre() + ", '" + usuario.getApellido() + "', '"
					+ usuario.getCorreo() + "', '" + usuario.getClave() + "')");
		}

		
		@Override
		public Usuario read(Integer id) {
			Usuario usuario = null;
			ResultSet rs = conexion.query("SELECT * FROM Persona WHERE id=" + id);
			try {
				if (rs != null && rs.next()) {
					usuario = new Usuario(rs.getInt("id"),rs.getString("cedula"), rs.getString("nombre"),
							rs.getString("apellido"),rs.getString("correo"),rs.getString("clave"));
				}
			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
			}

			return usuario;
		}

		@Override
		public void update(Usuario persona) {
			conexion.update("UPDATE Persona SET cedula = '" + persona.getCedula() + "', nombre = '" + persona.getNombre()
					+ "', apellido = '" + persona.getApellido() + "' WHERE id = " + persona.getId());

		}

		@Override
		public void delete(Usuario persona) {
			conexion.update("DELETE FROM Persona WHERE id = " + persona.getId());

		}

		@Override
		public List<Usuario> find() {
			List<Usuario> list = new ArrayList<Usuario>();
			ResultSet rs = conexion.query("SELECT * FROM Usuario");
			try {
				while (rs.next()) {
					list.add(new Usuario(rs.getInt("id"), rs.getString("cedula"), rs.getString("nombre"),
							rs.getString("apellido"),rs.getString("correo"),rs.getString("clave")));
				}

			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBCUsuarioDAO:find): " + e.getMessage());
			}
			return list;
		}

	}

