package com.codingdojo.Book.Services;

import com.codingdojo.Book.Models.Book;
import com.codingdojo.Book.Repositiories.BookRepo;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public void createBook(Book book) {
        bookRepo.save(book);
    }

    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        return optionalBook.orElse(null);
    }

    public void updateBookById(Long id, Book updatedBook) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setThoughts(updatedBook.getThoughts());
            bookRepo.save(book);
        }
    }

    public void deleteBookById(Long id) {
        bookRepo.deleteById(id);
    }
}
