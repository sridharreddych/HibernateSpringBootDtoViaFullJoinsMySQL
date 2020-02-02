package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nfetchAuthorsAndBooksSql: ");
            bookstoreService.fetchAuthorsAndBooksSql()
                    .forEach((e) -> System.out.println(e.getName() + " | " + e.getTitle()));
        };
    }
}
/*
*
*How To Use Spring Projections(DTOs) And Inclusive Full Joins (MySQL)



Description: This application is a proof of concept for using Spring Projections(DTO) and inclusive full joins written in native SQL (for MySQL).

Key points:

define two entities (e.g., Author and Book in a lazy bidirectional @OneToMany relationship)
populate the database with some test data (e.g., check the file resources/data-mysql.sql)
write interfaces (projections) that contains getters for the columns that should be fetched from the database (e.g., check AuthorNameBookTitle.java)
write inclusive full joins queries using native SQL
*/