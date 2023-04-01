package hibernate.dao;

import java.util.List;

import hibernate.model.Customer;

public interface Dao {
	public List<Customer> getAll();
}
