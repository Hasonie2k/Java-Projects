package com.codingdojo.dojos_ninjas.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojos_ninjas.models.Dojo;
import com.codingdojo.dojos_ninjas.models.Ninja;
import com.codingdojo.dojos_ninjas.services.DojoService;
import com.codingdojo.dojos_ninjas.services.NinjaService;

@Controller
public class Controllers {

    private final DojoService dojoService;
    private final NinjaService ninjaService;

    public Controllers(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Dojo> dojos = dojoService.getAllDojos();
        model.addAttribute("dojos", dojos);
        model.addAttribute("newDojo", new Dojo());
        model.addAttribute("newNinja", new Ninja()); // Add this line to create a new Ninja object
        return "index.jsp";
    }

    @PostMapping("/dojos")
    public String createDojo(@ModelAttribute("newDojo") Dojo dojo, Model model) {
        dojoService.createDojo(dojo);
        Long dojoId = dojo.getId();
        return "redirect:/ninja/" + dojoId;
    }


    @PostMapping("/ninjas")
    public String createNinja(@ModelAttribute("newNinja") Ninja ninja, Model model) {
        Long dojoId = ninja.getDojo().getId();
        Dojo dojo = dojoService.getDojoById(dojoId);
        ninja.setDojo(dojo);
        ninjaService.createNinja(ninja);
        return "redirect:/ninja/" + dojoId;
    }

    @GetMapping("/ninja/{dojoId}")
    public String showNinjasForDojo(@PathVariable("dojoId") Long dojoId, Model model) {
        Dojo dojo = dojoService.getDojoById(dojoId);
        List<Ninja> ninjas = ninjaService.getNinjasByDojoId(dojoId);
        model.addAttribute("dojoName", dojo.getName());
        model.addAttribute("ninjas", ninjas);
        model.addAttribute("dojos", dojoService.getAllDojos()); // Add this line to make all dojos available in the JSP
        return "ninja.jsp";
    }
}



