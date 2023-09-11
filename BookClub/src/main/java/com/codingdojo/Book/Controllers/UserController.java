package com.codingdojo.Book.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.Book.Models.User;
import com.codingdojo.Book.Services.UserService;
import com.codingdojo.Book.validates.LoginValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
@Autowired
private UserService uService;
	@GetMapping("")
	public String index(@ModelAttribute("newUser")User newUser, Model viewModel) {
		viewModel.addAttribute("loginUser", new LoginValidator());
		return "index.jsp";
	}
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User hello, 
            BindingResult result, Model model, HttpSession session) {
        User newestUser = this.uService.register(hello, result);
        if(result.hasErrors()) {
            model.addAttribute("loginUser", new LoginValidator());
            return "index.jsp";
        }
        session.setAttribute("userId", newestUser.getId());
        return "redirect:/users/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginUser") LoginValidator newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = uService.login(newLogin, result);
        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("userId", user.getId()); // Storing the user ID instead of the entire user object
        return "redirect:/users/home";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
}

