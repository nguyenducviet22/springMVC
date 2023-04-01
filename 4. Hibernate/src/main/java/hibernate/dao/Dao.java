package hibernate.dao;

import java.util.List;

public interface Dao<T> {

	public List<T> getAll();

	public T getById(Integer t);
	
	public List<T> getByName(String t);

	public boolean insert(T t);

	public boolean update(T t);

	public boolean delete(Integer t);
}
