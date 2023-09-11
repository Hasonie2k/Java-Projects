package com.codingdojo.SaveTravels.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.SaveTravels.Model.Save;
import com.codingdojo.SaveTravels.services.SaveService;

@Controller
public class Controllers {
    private final SaveService saveService;

    @Autowired
    public Controllers(SaveService saveService) {
        this.saveService = saveService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex(Model model) {
        List<Save> allSaves = saveService.getAllSaves();
        model.addAttribute("saves", allSaves);
        return "index.jsp";
    }
    
    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable("id") Long id, Model model) {
        Save save = saveService.getSaveById(id);
        model.addAttribute("save", save);
        return "edit.jsp";
    }
    
    @PostMapping("/edit/{id}")
    public String updateSave(@PathVariable("id") Long id, Save updatedSave, RedirectAttributes redirectAttributes) {
        updatedSave.setId(id); // Set the ID of the updatedSave object
        
        Save save = saveService.updateSave(id, updatedSave);
        if (save != null) {
            redirectAttributes.addFlashAttribute("successMessage", "Save edited successfully");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to edit save");
        }
        
        return "redirect:/";
    }
    
    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute("save", new Save());
        return "create.jsp";
    }
    
    @PostMapping("/save")
    public String createSave(Save save, RedirectAttributes redirectAttributes) {
        Save createdSave = saveService.createSave(save);
        if (createdSave != null) {
            redirectAttributes.addFlashAttribute("successMessage", "Save created successfully");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to create save");
        }
        
        return "redirect:/";
    }
        @GetMapping("/delete/{id}")
        public String deleteSave(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
            saveService.deleteSave(id);
            redirectAttributes.addFlashAttribute("successMessage", "Save deleted successfully");
            return "redirect:/";
        }
        @GetMapping("/view/{id}")
        public String getViewPage(@PathVariable("id") Long id, Model model) {
            Save save = saveService.getSaveById(id);
            model.addAttribute("save", save);
            return "view.jsp";
        }

}


