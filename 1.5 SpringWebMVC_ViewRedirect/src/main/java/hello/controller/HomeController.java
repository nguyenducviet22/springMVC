package hello.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hello.model.User;

@Controller
public class HomeController {

//	@Autowired
//	@Qualifier("person2")
//	private User person;

	@RequestMapping(value = { "/", "/home" })
	public String home(Model model,
//			@RequestParam(value = "first_name", required = false) String firstName,
//			@RequestParam(value = "last_name", required = false) String lastName
			@RequestParam Map<String, String> params) {
		String firstName = params.get("first_name");
		String lastName = params.get("last_name");

		if (firstName != null && lastName != null) {
			model.addAttribute("name", String.format("%s %s", firstName, lastName));
		} else {
			model.addAttribute("name", "Nguyen Duc Viet");
//			model.addAttribute("person", person);
		}
		model.addAttribute("user", new User());
		return "home";
	}

	@RequestMapping(value = "/hello/{name}")
	public String hello(Model model, @PathVariable(value = "name") String name) {
		model.addAttribute("user", name);
		return "hello";
	}
	
	@RequestMapping(path = "/hello-post", method = RequestMethod.POST)
	public String show(Model model, @ModelAttribute(value="user") User user) {
		model.addAttribute("fullName", user.getLastName()+ " " +user.getFisrtName());
		return "home";
	}
	
	@RequestMapping(path = "/forward")
	public String testForward(Model model) {
		model.addAttribute("testMsg", "FORWARD");
		return "forward:/hello/Viet";
	}
	
	@RequestMapping(path = "/redirect")
	public String testRedirect(Model model) {
		model.addAttribute("testMsg", "REDIRECT");
		return "redirect:/hello/Viet";
	}
}
