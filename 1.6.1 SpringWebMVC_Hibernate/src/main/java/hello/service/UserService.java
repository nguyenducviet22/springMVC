package hello.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.dao.UserDao;
import hello.model.User;

public interface UserService<T> {

	public List<T> getAll();

	public T getById(Integer t);

	public List<T> searchByName(String t);

	public void insert(T t);

	public void update(T t);

	public void delete(Integer t);

}

