package com.SemTask.EGFIE3.repository;

import com.SemTask.EGFIE3.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
