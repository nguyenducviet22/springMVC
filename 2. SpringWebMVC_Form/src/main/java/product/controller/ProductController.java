package product.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import product.model.Product;

@Controller
public class ProductController {
	@RequestMapping(value = { "/", "/initInsert" })
	public String initInsert(Model model) {
		Product product = new Product();
		model.addAttribute("pro", product);
		return "insert";
	}
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute("pro")Product product, Model model) {
		model.addAttribute("pro", product);
		return "/home";
	}
}
