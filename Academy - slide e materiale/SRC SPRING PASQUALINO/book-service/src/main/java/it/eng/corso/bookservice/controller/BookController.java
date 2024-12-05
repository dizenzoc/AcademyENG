package it.eng.corso.bookservice.controller;

import it.eng.corso.bookservice.model.Book;
import it.eng.corso.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> findAll( ){
        return bookService.findAll();
    }

    @GetMapping("/search")
    public List<Book> findByAuthor(@RequestParam String author ){
        return bookService.findByAuthor( author );
    }

    @GetMapping("/{id}")
    public Book findById( @PathVariable Long id ){
        return bookService.findById( id );
    }

    @PostMapping
    public Book save( @RequestBody Book book ){
        return bookService.save( book );
    }

    @PutMapping("/{id}")
    public Book update( @PathVariable Long id, @RequestBody Book book ){
        return bookService.update(id, book );
    }

    @PatchMapping("/{id}")
    public Book partialUpdate( @PathVariable Long id, @RequestBody Book book ){
        return bookService.partialUpdate(id, book );
    }


    @DeleteMapping("/{id}")
    public void delete( @PathVariable Long id ){
        bookService.delete( id );
    }

}
