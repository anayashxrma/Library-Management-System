package com.library.library_management_system.controller;

import com.library.library_management_system.model.Book;
import com.library.library_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book book = bookService.findById(id);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setBorrowed(bookDetails.isBorrowed());
            return ResponseEntity.ok(bookService.save(book));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (bookService.findById(id) != null) {
            bookService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
