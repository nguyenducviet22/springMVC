package hello.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hello.model.User;
import hello.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService<User> userService;
	
	@RequestMapping(value = { "/", "/home" })
	public String home(Model model) {
		model.addAttribute("list", this.userService.getAll());
		return "home";
	}

}
