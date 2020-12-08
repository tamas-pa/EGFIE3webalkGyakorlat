package com.semtask.egfie3.controllers;

import java.util.Optional;

import javax.websocket.server.PathParam;

import com.semtask.egfie3.domain.Book;
import com.semtask.egfie3.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());
        return "list";
    }

    @RequestMapping("/bookform")
    public String updateBook(@RequestParam Optional<String> id, Model model) {
        if (id.isPresent()) {
            model.addAttribute("book", bookRepository.findById(Long.parseLong(id.get())));
        }
        else model.addAttribute("book", new Book());

        return "bookform";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book, Model model) {
        model.addAttribute("book", book);
        bookRepository.save(book);
        return "done";
    }

    @RequestMapping("/delete")
    public String deleteBook(@RequestParam String id, Model model) {
        bookRepository.delete(bookRepository.findById(Long.parseLong(id)).get());
        return "done";
    }

}
