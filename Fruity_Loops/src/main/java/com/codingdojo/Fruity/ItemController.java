package com.codingdojo.Fruity;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {
    @RequestMapping("/")
    public String index(Model model) {
    	
        ArrayList<Models> fruits = new ArrayList<>();
        fruits.add(new Models("Kiwi", 1.5));
        fruits.add(new Models("Mango", 2.0));
        fruits.add(new Models("Goji Berries", 4.0));
        fruits.add(new Models("Guava", 0.75));
        
        model.addAttribute("fruits", fruits);
        return "index.jsp";
    }
}
