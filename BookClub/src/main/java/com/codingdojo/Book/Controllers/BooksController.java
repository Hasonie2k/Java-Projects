package com.codingdojo.Book.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.Book.Models.Book;
import com.codingdojo.Book.Models.User;
import com.codingdojo.Book.Services.BookService;
import com.codingdojo.Book.Services.UserService;

import jakarta.servlet.http.HttpSession;
@Validated
@Controller
public class BooksController {
    private final UserService userService;
    private final BookService bookService;

    public BooksController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/users/home")
    public String homeRoute(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User currentUser = this.userService.findByid(userId);
        model.addAttribute("currentUser", currentUser);

        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);

        return "Dashboard.jsp";
    }
    
    

    @GetMapping("/users/create")
    public String showCreateBookForm(Model model) {
        model.addAttribute("newBook", new Book());
        return "create.jsp";
    }
    
    

    @PostMapping("/users/create/book")
    public String createBook(@Validated @ModelAttribute("newBook") Book book, BindingResult result,
                             Model model, HttpSession session) {
        if (result.hasErrors()) {
            model.addAttribute("newBook", book);
            return "create.jsp";
        } else {
            Long userId = (Long) session.getAttribute("userId");
            User currentUser = userService.findByid(userId);

            book.setUser(currentUser);

            bookService.createBook(book);
            return "redirect:/users/home";
        }
    }
    
    @PostMapping("/users/edit/book/{id}")
    public String updateBook(@PathVariable("id") Long id, @Validated @ModelAttribute("book") Book updatedBook, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("book", updatedBook);
            return "EditBook.jsp";
        }

        Book book = bookService.getBookById(id);
        if (book == null) {
            return "redirect:/users/home";
        }

        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setThoughts(updatedBook.getThoughts());

        bookService.updateBookById(id, book);

        return "redirect:/users/view/book/" + id;
    }

   
    @GetMapping("/users/edit/book/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return "redirect:/users/home";
        }
        model.addAttribute("book", book);

        return "EditBook.jsp";
    } 
    
    @GetMapping("/users/view/book/{id}")
    public String viewBook(@PathVariable("id") Long id, Model model, HttpSession session) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return "redirect:/users/home";
        }
        model.addAttribute("book", book);

        Long userId = (Long) session.getAttribute("userId");
        User currentUser = this.userService.findByid(userId);

        // Check if the current user ID matches the book's creator ID
        boolean isCreator = userId != null && userId.equals(book.getUser() != null ? book.getUser().getId() : null);
        model.addAttribute("isCreator", isCreator);

        // Pass the currentUser to the view
        model.addAttribute("currentUser", currentUser);

        return "ViewBook.jsp";
    }


    
    @DeleteMapping("/users/delete/book/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return "redirect:/users/home";
    }
    
}


