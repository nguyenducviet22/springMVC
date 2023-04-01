package hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import hibernate.model.Customer;
import hibernate.dao.Dao;

@Controller
public class CustomerController {

	@Autowired
	private Dao<Customer> dao;
	
	@RequestMapping(value = { "/", "/listCustomers" })
	public String home(Model model) {
		List<Customer> list = dao.getAll();
		model.addAttribute("list", list);
		return "listCustomers";
	}
	
	@RequestMapping("/initInsert")
	public String init(Model model) {
		Customer customer = new Customer();
		model.addAttribute("cus", customer);
		return "insert";
	}
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute("cus")Customer customer, Model model) {
		boolean bl = dao.insert(customer);
		if (bl) {
			return "redirect:/listCustomers";
		} else {
			model.addAttribute("error", "Insert unsuccessfully");
			model.addAttribute("cus", customer);
			return "insert";
		}
	}
}
