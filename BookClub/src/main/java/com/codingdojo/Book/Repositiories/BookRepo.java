package com.codingdojo.Book.Repositiories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.Book.Models.Book;

	@Repository
	public interface BookRepo extends CrudRepository<Book, Long> {
	    List<Book> findAll();
	}


