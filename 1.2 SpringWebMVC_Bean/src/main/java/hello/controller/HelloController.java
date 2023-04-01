package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hello.model.Person;

@Controller
public class HelloController {
	
	@Autowired
	@Qualifier("person2")
	private Person person;
	
	@RequestMapping(value = { "/", "/home" })
	public String home(Model model) {
//		model.addAttribute("name", "Nguyen Duc Viet");
		model.addAttribute("person", person);
		return "home";
	}
}
