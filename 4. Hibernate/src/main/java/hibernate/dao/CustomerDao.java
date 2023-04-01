package hibernate.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.model.Customer;
import hibernate.util.HibernateUtil;

public class CustomerDao implements Dao<Customer> {

	@Override
	public List<Customer> getAll() {
		List<Customer> list = new ArrayList<Customer>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				String hql = "from Customer";
				Query query = session.createQuery(hql);
				list = query.getResultList();
				trans.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Customer getById(Integer id) {
		Customer customer = new Customer();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				String hql = "from Customer where id = :id";
				Query query = session.createQuery(hql);
				query.setParameter("id", id);
				customer = (Customer) query.getResultList();
				trans.commit();
				session.close();
				return customer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> getByName(String name) {
		List<Customer> list = new ArrayList<Customer>();
		if (name == null || name.length() == 0) {
			name = "%";
		} else {
			name = "%" + name + "%";
		}
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				String hql = "from Customer where name like :username";
				Query query = session.createQuery(hql);
				query.setParameter("username", name);
				list = query.getResultList();
				trans.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean saveOrUpdate(Customer customer) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				session.saveOrUpdate(customer);
				trans.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insert(Customer t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean update(Customer t) {
		return saveOrUpdate(t);
	}

	@Override
	public boolean delete(Integer t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				session.delete(t);
				trans.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		CustomerDao cusDao = new CustomerDao();
		
		List<Customer> list = cusDao.getAll();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		
//		Customer customer = new Customer("user2", "123", "use2", "Other", "Binh Duong", "Binh Duong",
//				new Date(System.currentTimeMillis()), "0123", "abc@gmail.com");
//		cusDao.insert(customer);
	}

}
