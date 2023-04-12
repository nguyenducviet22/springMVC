package customer.service;

import org.springframework.stereotype.Service;

import customer.entities.Account;

@Service
public interface AccountService {

	public boolean insertAccount(Account account);
}
