package com.semtask.egfie3.bootstrap;

import com.semtask.egfie3.domain.Author;
import com.semtask.egfie3.domain.Book;
import com.semtask.egfie3.domain.Publisher;
import com.semtask.egfie3.repositories.AuthorRepository;
import com.semtask.egfie3.repositories.BookRepository;
import com.semtask.egfie3.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

   // private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
   // private final PublisherRepository publisherRepository;

    public BootStrapData(//AuthorRepository authorRepository,
     BookRepository bookRepository
     //,PublisherRepository publisherRepository
     ) {
     //   this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
     //   this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*System.out.println("Started in Bootsrap");

        Publisher publisher = new Publisher("SGF Publishing","Hungary","Miskolc","BAZ","3525");

        publisherRepository.save(publisher);
        System.out.println("Publisher count: "+ publisherRepository.count());

        Author eric =new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB=new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("Number of Books: "+ bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
        */
        bookRepository.save(new Book("Cím", "1231241", "Jó Szerző"));
    }
}
