package com.SemTask.EGFIE3.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String aname;
    private int age;
    private Long books;

    public Publisher() {

    }

    public Publisher(Long id, String aname, int age, Long books) {
        this.id = id;
        this.aname = aname;
        this.age = age;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getBooks() {
        return books;
    }

    public void setBooks(Long books) {
        this.books = books;
    }
}
