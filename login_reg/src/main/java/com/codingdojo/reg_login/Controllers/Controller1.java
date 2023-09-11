package com.codingdojo.reg_login.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.reg_login.models.User;
import com.codingdojo.reg_login.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class Controller1 {

	private final UserService userService;

	public Controller1(UserService userService) {
	    this.userService = userService;
	}

	@GetMapping("/")
	public String index(Model model) {
	    model.addAttribute("newUser", new User());
	    model.addAttribute("newLogin", new User());
	    return "index.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
	                       BindingResult result, Model model, HttpSession session) {

	    User registeredUser = userService.register(newUser, result);

	    if (result.hasErrors() || registeredUser == null) {
	        model.addAttribute("newLogin", new User());
	        return "index.jsp";
	    }

	    return "redirect:/home";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email,
	                    @RequestParam("password") String password,
	                    BindingResult result, Model model, HttpSession session) {

	    User user = userService.login(email, password, result);

	    if (result.hasErrors() || user == null) {
	        model.addAttribute("newUser", new User());
	        return "index.jsp";
	    }

	    return "redirect:/home";
	}
	
}







