package com.codingdojo.SQL.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.SQL.models.Book;

@Repository
	public interface BookRepository extends CrudRepository <Book,Long> {
    // this method retrieves all the books from the database
    List<Book> findAll();
    // this method finds books with descriptions containing the search string
    List<Book> findByDescriptionContaining(String search);
}
