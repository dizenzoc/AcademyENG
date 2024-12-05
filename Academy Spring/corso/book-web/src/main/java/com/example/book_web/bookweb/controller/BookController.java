package com.example.book_web.bookweb.controller;

import com.example.book_web.bookweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String listBook( Model model ) {
        model.addAttribute("books", bookService.findAll());
        return "home";
    }
}
