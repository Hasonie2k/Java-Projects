package com.codingdojo.kickball.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.kickball.Models.Team;
import com.codingdojo.kickball.Models.User;
import com.codingdojo.kickball.Services.TeamService;
import com.codingdojo.kickball.Services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Valid
@Controller
@RequestMapping("/team")
public class TeamController {

    private final UserService userService;
    private final TeamService teamService;

    public TeamController(UserService userService, TeamService teamService) {
        this.userService = userService;
        this.teamService = teamService;
    }
    
    @GetMapping("/home")
    public String homeRoute(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if(userId== null) {
        	return "redirect:/";

        }
        User currentUser = this.userService.findByid(userId);

        model.addAttribute("currentUser", currentUser);

        List<Team> teams = teamService.getAllTeams();
        model.addAttribute("teams", teams);

        return "Dashboard.jsp";
    }
    
    
    @GetMapping("/create")
    public String showCreateTeamForm(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User currentUser = userService.findByid(userId);

        model.addAttribute("newTeam", new Team());
        model.addAttribute("currentUser", currentUser);

        return "Create.jsp";
    }
    
    @PostMapping("/create/team")
    public String createTeam(@Valid @ModelAttribute("newTeam") Team newTeam,
                             BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            model.addAttribute("newTeam", newTeam);
            return "Create.jsp";
        } else {
            Long userId = (Long) session.getAttribute("userId");
            User currentUser = userService.findByid(userId);

            if (currentUser == null) {
                return "redirect:/team/home";
            }

            newTeam.setUser(currentUser);
            
            teamService.createTeam(newTeam);
            return "redirect:/team/home";
        }
    }
    @GetMapping("/view/team/{id}")
    public String viewTeam(@PathVariable("id") Long id, Model model, HttpSession session) {
        Team Team = teamService.getTeamById(id);
        if (Team == null) {
            return "redirect:/team/home";
        }

        Long userId = (Long) session.getAttribute("userId");
        User currentUser = userService.findByid(userId);

        model.addAttribute("team", Team);
        model.addAttribute("currentUser", currentUser);

        return "View.jsp";
    }
    
    @GetMapping("/edit/team/{id}")
    public String editTeam(@PathVariable("id") Long id, Model model) {
        Team team = teamService.getTeamById(id);
        if (team == null) {
            return "redirect:/team/home";
        }
        model.addAttribute("team", team);

        return "Edit.jsp";
    }

    @PostMapping("/update/team/{id}")
    public String updateTeam(@PathVariable("id") Long id,
                             @Valid @ModelAttribute("team") Team updatedTeam,
                             BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "Edit.jsp";
        }

        updatedTeam.setUser(userService.findByid((Long)session.getAttribute("userId")));
        teamService.updateTeamById(updatedTeam);

        return "redirect:/team/home";
    }

    
    @DeleteMapping("/delete/team/{id}")
    public String deleteTeam(@PathVariable("id") Long id) {
        teamService.deleteTeamById(id);
        return "redirect:/team/home";
    }
    
}




