package hibernate.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hibernate.model.Customer;

@Repository
public class CustomerDao implements Dao<Customer> {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getAll() {
		Session session = sessionFactory.openSession();
		String hql = "from Customer";
		try {
			Query query = session.createQuery(hql);
			List<Customer> list = query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Customer getById(Integer id) {
		Session session = sessionFactory.openSession();
		String hql = "from Customer where id = :id";
		try {
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			Customer customer = (Customer) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Customer> getByName(String name) {
		Session session = sessionFactory.openSession();
		String hql = "from Customer where name like :username";
		if (name == null || name.length() == 0) {
			name = "%";
		} else {
			name = "%" + name + "%";
		}
		try {
			Query query = session.createQuery(hql);
			query.setParameter("username", name);
			List<Customer> list = query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	public boolean saveOrUpdate(Customer customer) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(customer);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean insert(Customer t) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean update(Customer t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Integer t) {
		Session session = sessionFactory.openSession();
		try {
			Transaction trans = session.beginTransaction();
			session.delete(t);
			trans.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public static void main(String[] args) {
		CustomerDao cusDao = new CustomerDao();

		List<Customer> list = cusDao.getAll();
		for (Customer customer : list) {
			System.out.println(customer);
		}

//		Customer cus = cusDao.getById(1);
//		System.out.println(cus);

//		Customer customer = new Customer("user3", "123", "use3", "Male", "Binh Duong", "Binh Duong",
//				new Date(System.currentTimeMillis()), "0123", "abc@gmail.com");
//		cusDao.insert(customer);
	}

}
