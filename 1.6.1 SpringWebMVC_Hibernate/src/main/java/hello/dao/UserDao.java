package hello.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hello.model.User;

public interface UserDao<T> {

	List<T> getAll();

	T getById(Integer t);

	List<T> searchByName(String t);

	void insert(T t);

	void update(T t);

	void delete(Integer t);

}

