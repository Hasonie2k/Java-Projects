package com.codingdojo.kickball.Repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.kickball.Models.Team;

	@Repository
	public interface TeamRepo extends CrudRepository<Team, Long> {
	    List<Team> findAll();
	}
