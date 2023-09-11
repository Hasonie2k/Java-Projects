package com.codingdojo.SQL.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.SQL.models.Book;
import com.codingdojo.SQL.services.bookService;

@Controller
public class BookController {
	
	@Autowired
	bookService bookService;
	
   @RequestMapping("/books/{bookId}")
   public String index(Model model ,@PathVariable("bookId") Long bookId) {
	   
	  Book book = bookService.findBook(bookId);
	  model.addAttribute("book", book);
	   return "index.jsp";
   }
}
 