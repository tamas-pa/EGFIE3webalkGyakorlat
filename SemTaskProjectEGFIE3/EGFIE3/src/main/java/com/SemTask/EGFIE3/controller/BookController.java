package com.SemTask.EGFIE3.controller;

import com.SemTask.EGFIE3.models.Book;
import com.SemTask.EGFIE3.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/index")
    public String index(Model model) throws IOException{
        model.addAttribute("list", bookService.findAll());
        return "index";

    }

    @GetMapping("/form={ID}")
    public String formUpdate(@PathVariable(value = "ID") String id, Model model) throws IOException {
        try {
            model.addAttribute("book", bookService.findById(Long.parseLong(id)));
        } catch (NumberFormatException e) {

        }
        return "form";

    }

    @GetMapping("/form")
    public String formInsert(Model model) throws IOException {
        model.addAttribute("book", new Book());
        return "form";
    }

    @PostMapping("/update")
    public String formSubmit(@ModelAttribute Book book, Model model) {
        model.addAttribute("book", book);
        bookService.save(book);
        return "proceeded";
    }

    @GetMapping("/delete={ID}")
    public String delete(@PathVariable(value = "ID") String id, Model model) throws IOException {
        try {
            Long longid = Long.parseLong(id);
            bookService.delete(bookService.findById(longid));
        } catch (NumberFormatException e) {

        }
        return "proceeded";

    }
}
