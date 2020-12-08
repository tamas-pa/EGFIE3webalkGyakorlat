package com.semtask.egfie3.repositories;

import java.util.Optional;

import com.semtask.egfie3.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {


}
