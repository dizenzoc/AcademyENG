package it.eng.corso.bookservice.service;

import it.eng.corso.bookservice.model.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();

    List<Book> findByAuthor(String author );

    Book findById( Long id );

    void delete(Long id);

    Book update(Long id, Book book);

    Book partialUpdate(Long id, Book book);
}
