package com.codingdojo.kickball.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.kickball.Models.User;
import com.codingdojo.kickball.Services.UserService;
import com.codingdojo.kickball.validates.LoginValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String index(@ModelAttribute("newUser") User newUser, Model viewModel) {
        viewModel.addAttribute("loginUser", new LoginValidator());
        return "index.jsp";
    }

    @PostMapping("register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
                           BindingResult result, Model model, HttpSession session) {
        User newestUser = this.userService.register(newUser, result);
        if (result.hasErrors()) {
            model.addAttribute("loginUser", new LoginValidator());
            return "index.jsp";
        }
        session.setAttribute("userId", newestUser.getId());
        return "redirect:/team/home";
    }

    @PostMapping("login")
    public String login(@Valid @ModelAttribute("loginUser") LoginValidator newLogin,
                        BindingResult result, Model model, HttpSession session) {
        User user = userService.login(newLogin, result);
        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("userId", user.getId()); // Storing the user ID instead of the entire user object
        return "redirect:/team/home";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}


