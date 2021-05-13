package ec.edu.ups.dao;

import ec.edu.ups.jdbc.JDBCTelefonoDAO;
import ec.edu.ups.jdbc.JDBCUsuarioDAO;
	
public class JDBCDAOFactory extends DAOFactory {

	@Override
	public void createTables() {
		this.getUsuarioDAO().createTable();		

	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new JDBCUsuarioDAO();
	}
	
	@Override
	public TelefonoDAO getTelefonoDAO() {
		return new JDBCTelefonoDAO();
	}

}
