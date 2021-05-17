package ec.edu.ups.dao;

import java.util.List;

 
public interface GenericDAO<T, ID> {

		public void createTable();

		public void create(T entity);

		public T read(ID id);
		
		//verificaraaa aa--
		public T readLogin(String correo, String clave);

		public void update(T entity);

		public void delete(T entity);

		public List<T> find();

}
