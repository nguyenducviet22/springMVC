package hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hibernate.dao.Dao;
import hibernate.model.Customer;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private Dao dao;
	
	@RequestMapping(value = {"/","/ListCustomer"})
	public String listCustomer(Model model) {
		List<Customer> list = dao.getAll();
		model.addAttribute("list", list);
		return "home";
	}
}
