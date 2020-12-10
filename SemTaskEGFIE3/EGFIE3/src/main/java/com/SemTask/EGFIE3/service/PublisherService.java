package com.SemTask.EGFIE3.service;

import com.SemTask.EGFIE3.models.Publisher;
import com.SemTask.EGFIE3.repository.PublisherReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherReposytory publisherReposytory;

    public List<Publisher> findAll() {return (List<Publisher>) publisherReposytory.findAll();}

    public Publisher findById(long id) {
        return publisherReposytory.findById(id).get();
    }

    public void save(Publisher publisher){publisherReposytory.save(publisher);}

    public void delete(Publisher publisher) {publisherReposytory.delete(publisher);}
}
