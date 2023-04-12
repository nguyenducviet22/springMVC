package hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hibernate.dao.Dao;
import hibernate.model.Customer;
import hibernate.service.Service;

@org.springframework.stereotype.Service
public class CustomerService implements Service<Customer> {
	
	@Autowired
	Dao<Customer> dao;

	@Override
	public List<Customer> getAll() {
		return dao.getAll();
	}

	@Override
	public Customer getById(Integer t) {
		return dao.getById(t);
	}

	@Override
	public List<Customer> searchByName(String t) {
		// TODO Auto-generated method stub
		return dao.searchByName(t);
	}

	@Override
	public boolean insert(Customer t) {
		// TODO Auto-generated method stub
		return dao.insert(t);
	}

	@Override
	public boolean update(Customer t) {
		// TODO Auto-generated method stub
		return dao.update(t);
	}

	@Override
	public boolean delete(Integer t) {
		// TODO Auto-generated method stub
		return dao.delete(t);
	}

}
