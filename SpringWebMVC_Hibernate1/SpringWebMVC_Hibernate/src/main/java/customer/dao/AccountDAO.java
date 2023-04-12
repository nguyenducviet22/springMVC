package customer.dao;

import java.util.List;

import customer.entities.Account;

public interface AccountDAO {
	//gọi lên list account
	public List<Account> getAccounts();
	
	//insert new Account
	public boolean insertAccount(Account account);
	
	//lấy ra Account thông qua username
	public Account getAccountByUsername(String username);
	
	//xoá Account thông qua username
	public boolean deleteAccountByUsername(String username);
	
	//update Account thông qua username
	public boolean updateAccountByUsername(Account account);
	
	//search Account thông qua username
	public List<Account> searchAccountByUsername(String username);
	
	//tính tổng số Account đang tồn tại
	public Integer countTotalAccount();
	
	//gọi lên Account cho từng page
	public List<Account> getAccountByPage(Integer indexPage);
}
