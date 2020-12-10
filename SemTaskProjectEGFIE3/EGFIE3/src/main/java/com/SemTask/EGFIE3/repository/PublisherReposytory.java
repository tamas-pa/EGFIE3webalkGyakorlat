package com.SemTask.EGFIE3.repository;

import com.SemTask.EGFIE3.models.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherReposytory extends CrudRepository<Publisher, Long> {
}
