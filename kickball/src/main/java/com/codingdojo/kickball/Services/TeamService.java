package com.codingdojo.kickball.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.kickball.Models.Team;
import com.codingdojo.kickball.Repositories.TeamRepo;

@Service
public class TeamService {
    private final TeamRepo teamRepository;

    @Autowired
    public TeamService(TeamRepo teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team getTeamById(Long id) {
        Optional<Team> optionalHunt = teamRepository.findById(id);
        return optionalHunt.orElse(null);
    }


    public Team updateTeamById(Team updatedTeam) {
        return   teamRepository.save(updatedTeam); 
        }

    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }
}
