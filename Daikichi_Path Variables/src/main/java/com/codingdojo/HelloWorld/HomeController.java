package com.codingdojo.HelloWorld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")

public class HomeController {
    @RequestMapping("/travel/{city}")
    public String travelToCity(@PathVariable("city") String city) {
        return "Congratulations! You will soon travel to " + city + "!";
    }
    
    @RequestMapping("/lotto/{number}")
    public String analyzeLottoNumber(@PathVariable("number") int number) {
        if (number % 2 == 0) {
            return "You will take a grand journey in the near future, but be weary of tempting offers.";
        } else {
            return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
        }
    }
    
    @RequestMapping("/37")
    public String friends() {
        return "You have enjoyed video games too much. You should spend time with the family.";
    }
}
