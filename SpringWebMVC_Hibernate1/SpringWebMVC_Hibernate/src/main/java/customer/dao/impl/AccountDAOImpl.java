package customer.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import customer.dao.AccountDAO;
import customer.entities.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{
	
	//Autowired là chọc vào đối tượng nào để lấy ra sử dụng
	//đây giống như sử dụng depemtenci injection
	@Autowired 
	SessionFactory sessionFactory;
	
	@Override
	public List<Account> getAccounts() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Account").list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertAccount(Account account) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(account);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public Account getAccountByUsername(String username) {
		Session session = sessionFactory.openSession();
		try {
			Account account = session.get(Account.class, username);
			return account;
		}catch (Exception e) {          
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean deleteAccountByUsername(String username) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			//hàm delete là xoá theo Object chứ không phải xoá theo biến lên tham số 
			//lên tham số truyền vào sẽ là 1 hàm gọi ra 1 đối tượng thông qua dữ liệu lọc ra đối tượng đó (ở đây là username)
			session.delete(getAccountByUsername(username));
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateAccountByUsername(Account account) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(account);
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Account> searchAccountByUsername(String username) {
		Session session = sessionFactory.openSession();
		try {
			if(username == null || username.length()== 0) {
				username = "%";
			}else {
				username = "%" + username + "%";
			}
			List list = session.createQuery("from Account where username like :name").setParameter("name", username).list();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public Integer countTotalAccount() {
		Session session = sessionFactory.openSession();
		try {
			Query q = session.createQuery("select count(*) from Account");
			return Integer.parseInt(q.getSingleResult().toString());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;	
	}

	@Override
	public List<Account> getAccountByPage(Integer indexPage) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Account");
			int max = 2;
			//thiết lập số bản ghi tối đa mỗi lần truy vấn 
			//(cũng chính là số lượng sp sẽ hiển thị trong 1 trang)
			query.setMaxResults(max);
			//thiết lập vị trí bản ghi sẽ tiến hành truy vấn lên lên
			query.setFirstResult((indexPage - 1)*max);
			return query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
