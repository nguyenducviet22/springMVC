package hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hibernate.model.Customer;
import hibernate.service.Service;

@Controller
public class CustomerController {

	@Autowired
	Service<Customer> service;
	
	@RequestMapping(value = { "/", "/listCustomers" })
	public String home(Model model) {
		List<Customer> list = service.getAll();
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
		boolean bl = service.insert(customer);
		if (bl) {
			return "redirect:/listCustomers";
		} else {
			model.addAttribute("error", "Insert unsuccessfully");
			model.addAttribute("cus", customer);
			return "insert";
		}
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam("pid")Integer id, Model model) {
		Customer customer = service.getById(id);
		model.addAttribute("cus", customer);
		return "detail";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("pid")Integer id, Model model) {
		boolean bl = service.delete(id); 
		List<Customer> list = service.getAll();
		model.addAttribute("list", list);
		return "listCustomers";
	}
	
	@RequestMapping("/load")
	public String load(@RequestParam("pid")Integer id, Model model) {
		Customer customer = service.getById(id);
		model.addAttribute("cus", customer);
		return "update";
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute("cus")Customer customer, Model model) {
		boolean bl = service.update(customer);
		if (bl) {
			return "detail";
		} else {
			model.addAttribute("error", "Update unsuccessfully");
			model.addAttribute("cus", customer);
			return "update";
		}
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("searchName")String fullname, Model model) {
		List<Customer> list = service.searchByName(fullname);
		model.addAttribute("list", list);
		return "listCustomers";
	}
}
