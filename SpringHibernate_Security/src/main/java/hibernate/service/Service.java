package hibernate.service;

import java.util.List;

public interface Service<T> {
	
	List<T> getAll();

	T getById(Integer t);

	List<T> searchByName(String t);

	boolean insert(T t);

	boolean update(T t);

	boolean delete(Integer t);
}
