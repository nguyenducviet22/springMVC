package hibernate.dao;

import java.util.List;

public interface Dao<T> {

	List<T> getAll();

	T getById(Integer t);

	List<T> searchByName(String t);

	boolean insert(T t);

	boolean update(T t);

	boolean delete(Integer t);
}
