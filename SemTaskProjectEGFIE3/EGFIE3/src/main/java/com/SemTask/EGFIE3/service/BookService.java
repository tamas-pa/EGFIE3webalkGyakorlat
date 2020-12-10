package com.SemTask.EGFIE3.service;

import com.SemTask.EGFIE3.models.Book;
import com.SemTask.EGFIE3.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> findAll() { return (List<Book>) bookRepository.findAll();
    }

    public Book findById(long id){ return bookRepository.findById(id).get();}

    public void save(Book book){bookRepository.save(book);}
    public void delete(Book book){bookRepository.delete(book);}
}
