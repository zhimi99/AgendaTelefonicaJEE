package ec.edu.ups.jdbc;
	
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.entidades.Telefono;
	 
public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, String> implements TelefonoDAO {

	
		public void createTable() {
			conexion.update("DROP TABLE IF EXISTS Telefono");
			conexion.update("CREATE TABLE Telefono (" + "CODIGO INT NOT NULL, "
					+ "NUMERO VARCHAR(255), TIPO VARCHAR(255), OPERADORA VARCHAR(255), USU_CEDULA VARCHAR(10)" + ", PRIMARY KEY (CODIGO))");
		}
		
		
		public void create(Telefono telefono) {
			conexion.update("INSERT Telefono VALUES (" + telefono.getCodigo() + ",'" +telefono.getNumero() + "','" + telefono.getTipo() + "', '"
					+ telefono.getOperadora() + "','" + telefono.getUsuCedula().getCedula() + "')");
		}
		
		
		public Telefono read(String usuCedula) {
			Telefono telefono = null;
			
			//SELECT nombre,numero, tipo, operadora FROM jee.Telefono,  jee.Usuario where cedula = usuCedula;
			ResultSet rs = conexion.query("SELECT * FROM Telefono WHERE usuCedula=" + usuCedula);
			try {
				if (rs != null && rs.next()) {
					telefono = new Telefono(rs.getInt("codigo"), rs.getString("numero"),
							rs.getString("tipo"),rs.getString("operadora"));
				}
			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBCTelefonoDAO:read): " + e.getMessage());
			}

			return telefono;
		}
		
		//metodo verificar aaa---
		public Telefono readLogin(String a, String b) {
			Telefono telefono = null;
			
			//SELECT nombre,numero, tipo, operadora FROM jee.Telefono,  jee.Usuario where cedula = usuCedula;
			ResultSet rs = conexion.query("SELECT * FROM Telefono WHERE usuCedula=?" );
			try {
				if (rs != null && rs.next()) {
					telefono = new Telefono(rs.getInt("codigo"), rs.getString("numero"),
							rs.getString("tipo"),rs.getString("operadora"));
				}
			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBCTelefonoDAO:read): " + e.getMessage());
			}

			return telefono;
		}
		
		
		public void update(Telefono telefono) {
			conexion.update("UPDATE Telefono SET codigo = '" + telefono.getCodigo() + "', numero = '" + telefono.getNumero()
					+ "', tipo = '" + telefono.getTipo() + "', operador = '" + telefono.getOperadora() + "' WHERE usuCedula = " + telefono.getUsuCedula().getCedula());

		}

		
		public void delete(Telefono telefono) {
			conexion.update("DELETE FROM Telefono WHERE usuCedula = " + telefono.getUsuCedula().getCedula());

		}

		public List<Telefono> find() {
			List<Telefono> list = new ArrayList<Telefono>();
			ResultSet rs = conexion.query("SELECT * FROM Telefono");
			try {
				while (rs.next()) {
					list.add(new Telefono(rs.getInt("codigo"), rs.getString("numero"),
							rs.getString("tipo"),rs.getString("operadora")));
				}
				
			} catch (SQLException e) {
				System.out.println(">>>WARNING (JDBCTelefonoDAO:find): " + e.getMessage());
			}
			return list;
		}
	}

