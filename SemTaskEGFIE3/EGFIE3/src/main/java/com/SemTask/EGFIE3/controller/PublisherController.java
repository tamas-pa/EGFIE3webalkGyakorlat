package com.SemTask.EGFIE3.controller;

import com.SemTask.EGFIE3.models.Publisher;
import com.SemTask.EGFIE3.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/auindex")
    public String index(Model model) throws IOException {
        model.addAttribute("list", publisherService.findAll());
        return "auindex";
    }

    @GetMapping("/auform={ID}")
    public String formUpdate(@PathVariable(value = "ID") String id, Model model) throws IOException {
        try {
            model.addAttribute("publisher", publisherService.findById(Long.parseLong(id)));
        } catch (NumberFormatException e) {

        }
        return "auform";

    }

    @GetMapping("/auform")
    public String formInsert(Model model) throws IOException {
        model.addAttribute("publisher", new Publisher());
        return "auform";
    }

    @PostMapping("/auupdate")
    public String formSubmit(@ModelAttribute Publisher publisher, Model model) {
        model.addAttribute("publisher", publisher);
        publisherService.save(publisher);
        return "auproceeded";
    }

    @GetMapping("/audelete={ID}")
    public String delete(@PathVariable(value = "ID") String id, Model model) throws IOException {
        try {
            Long longid = Long.parseLong(id);
            publisherService.delete(publisherService.findById(longid));
        } catch (NumberFormatException e) {

        }
        return "auproceeded";

    }
}
