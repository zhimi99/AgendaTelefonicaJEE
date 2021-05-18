package ec.edu.ups.jdbc;
	
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.entidades.Telefono;
import ec.edu.ups.entidades.Usuario;
	 
public class JDBCTelefonoDAO extends JDBCGenericDAO<Telefono, Integer> implements TelefonoDAO {

	
		public void createTable() {
			conexion.update("DROP TABLE IF EXISTS Telefono");
			conexion.update("CREATE TABLE Telefono (" + "CODIGO INT NOT NULL, "
					+ "NUMERO VARCHAR(255), TIPO VARCHAR(255), OPERADORA VARCHAR(255), USU_CEDULA VARCHAR(10)" + ", PRIMARY KEY (CODIGO))");
		}
		
		
		public void create(Telefono telefono) {
			conexion.update("INSERT Telefono VALUES (" + telefono.getCodigo() + ",'" +telefono.getNumero() + "','" + telefono.getTipo() + "', '"
					+ telefono.getOperadora() + "','" + telefono.getUsuCedula().getCedula() + "')");
		}
		
		
		@Override
		public Telefono read(Integer id) {
			// TODO Auto-generated method stub
			JDBCUsuarioDAO jdbcusu = new JDBCUsuarioDAO();
			
			Telefono telefono = null;
			ResultSet rs = conexion.query("SELECT * FROM Telefono WHERE codigo="+id);
			try {
				if (rs!=null && rs.next()) {
					Usuario usuario = new Usuario();
					
					String numero = rs.getString("numero");
					String tipo = rs.getString("tipo");
					String operadora = rs.getString("operadora");
					String cedula = rs.getString("usuCedula");
					
					usuario = jdbcusu.read(cedula);
					
					telefono = new Telefono(id,numero, tipo, operadora, usuario);
				}
			} catch (Exception e) {
				System.out.println("Error red telefono: "+e.getMessage());
				return null;
			}
			return telefono;
		}
		
		
		
		public void update(Telefono telefono) {
			conexion.update("UPDATE Telefono SET codigo = '" + telefono.getCodigo() + "', numero = '" + telefono.getNumero()
					+ "', tipo = '" + telefono.getTipo() + "', operador = '" + telefono.getOperadora() + "' WHERE codigo = " + telefono.getCodigo());

		}

		
		public void delete(Telefono telefono) {
			conexion.update("DELETE FROM Telefono WHERE codigo = " + telefono.getCodigo());

		}

		
		
		@Override
		public List<Telefono> find() {
			JDBCUsuarioDAO udao = new JDBCUsuarioDAO();
			
			List<Telefono> list = new ArrayList<Telefono>();
			ResultSet rs = conexion.query("SELECT * FROM Telefono");
			try {
				while (rs.next()) {
					
					Usuario usuario = new Usuario();
					
					int codigo = rs.getInt("codigo");
					String numero = rs.getString("numero");
					String tipo = rs.getString("tipo");
					String operadora = rs.getString("operadora");
					String cedula = rs.getString("usuCedula");
					
					usuario = udao.read(cedula);
					Telefono telefono = new Telefono(codigo,numero,tipo,operadora,usuario);
					list.add(telefono);
				}
			} catch (Exception e) {
				System.out.println("Error list telefono: "+e.getMessage());
				return null;
			}
			return list;
		}
				
	}

