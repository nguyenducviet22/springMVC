package hello.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hello.dao.UserDao;
import hello.model.User;

@Repository
public class UserDaoImpl implements UserDao<User> {

	@Autowired
	private LocalSessionFactoryBean sessionFactory;

	@Override
	@Transactional
	public List<User> getAll() {
		Session session = sessionFactory.getObject().getCurrentSession();
		Query query = session.createQuery("from User");
		return query.getResultList();
	}

	@Override
	public User getById(Integer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchByName(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(User t) {
	}

	@Override
	public void update(User t) {

	}

	@Override
	public void delete(Integer t) {

	}

}
