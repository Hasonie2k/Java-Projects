package com.codingdojo.SaveTravels.repositories;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.SaveTravels.Model.Save;

	@Repository
	public interface Travel_Repository extends CrudRepository <Save,Long> {
    // this method retrieves all the books from the database
    List<Save> findAll();

  }


