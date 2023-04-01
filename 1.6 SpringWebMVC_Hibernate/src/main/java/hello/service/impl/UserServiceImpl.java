package hello.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.dao.UserDao;
import hello.model.User;
import hello.service.UserService;

@Service
public class UserServiceImpl implements UserService<User> {
	@Autowired
	private UserDao<User> userDao;

	@Transactional
	@Override
	public List<User> getAll() {
		return this.userDao.getAll();
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
		userDao.insert(t);
	}

	@Override
	public void update(User t) {

	}

	@Override
	public void delete(Integer t) {

	}

}
