package com.codingdojo.Test.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.codingdojo.Test.Models.TestModel;
import com.codingdojo.Test.Services.TestService;

@Controller
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("testModels", testService.getAllTestModels());
        return "index.jsp";
    }

    @GetMapping("/users/create") // Add GET mapping for create form
    public String createForm(Model model) {
        model.addAttribute("newTest", new TestModel());
        return "create.jsp";
    }

    @PostMapping("/users/create")
    public String create(@ModelAttribute("newTest") @Validated TestModel testModel, BindingResult result) {
        if (result.hasErrors()) {
            return "create.jsp";
        }
        testService.createTestModel(testModel);
        return "redirect:/";
    }



    @GetMapping("/users/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        TestModel testModel = testService.getTestModelById(id);
        if (testModel != null) {
            model.addAttribute("testModel", testModel);
            return "edit.jsp";
        }
        return "redirect:/";
    }

    @PostMapping("/users/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute("testModel") @Validated TestModel updatedTestModel, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        }
        testService.updateTestModelById(id, updatedTestModel.getPrice(), updatedTestModel.getUpdatedAt());
        return "redirect:/";
    }
    @GetMapping("/users/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        testService.deleteTestModelById(id);
        return "redirect:/";
    }

}





    