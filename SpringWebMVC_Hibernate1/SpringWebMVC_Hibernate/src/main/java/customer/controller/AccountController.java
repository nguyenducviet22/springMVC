package customer.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import customer.dao.AccountDAO;
import customer.entities.Account;

@Controller
public class AccountController {
	
	@Autowired
	private AccountDAO accountDAO;
	
	@RequestMapping(value = { "/", "/listCustomer" })
	public String home(Model model) {
		List list = accountDAO.getAccounts();
		model.addAttribute("list", list);
		return "listCustomer";
	}
}
