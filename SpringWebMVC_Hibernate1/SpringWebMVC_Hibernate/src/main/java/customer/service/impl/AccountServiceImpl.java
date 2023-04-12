package customer.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.dao.AccountDAO;
import customer.entities.Account;
import customer.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDAO accountDAO;
	
	@Override
	public boolean insertAccount(Account account) {
		//ma hoa mat khau
		//set lại mật khẩu cho account
		//BCrypt.hashpw() : phương thức băm mật khẩu
		//account.getPassword() : mật khẩu cần băm sau đó được set lại cho account
		//BCrypt.gensalt(12) : tiến hành băm theo độ phức tạp , chọn là 12
		account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(12)));
		return accountDAO.insertAccount(account);
	}

}
