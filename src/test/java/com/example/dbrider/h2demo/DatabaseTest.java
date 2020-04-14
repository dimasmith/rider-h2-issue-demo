package com.example.dbrider.h2demo;

import com.example.dbrider.h2demo.book.Book;
import com.example.dbrider.h2demo.book.BookRepository;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DBRider
class DatabaseTest {

    @Test
    @DisplayName("database setup fails on xml dataset and lowercase tables")
    @DataSet(value = "book/manage/readBooks-setup-failing.xml")
    void readLowercaseXml(@Autowired BookRepository bookRepository) {
        Iterable<Book> books = bookRepository.findAll();

        Assertions.assertThat(books)
            .extracting(Book::getTitle)
            .contains("mend", "weed");
    }

    @Test
    @DisplayName("database setup succeed on xml dataset and uppercase tables")
    @DataSet(value = "book/manage/readBooks-setup-ok.xml")
    void readUppercaseXml(@Autowired BookRepository bookRepository) {
        Iterable<Book> books = bookRepository.findAll();

        Assertions.assertThat(books)
            .extracting(Book::getTitle)
            .contains("mend", "weed");
    }

    @Test
    @DisplayName("database setup succeed on yaml dataset and lowercase tables")
    @DataSet(value = "book/manage/readBooks-setup-ok.yml")
    void readLowercaseYaml(@Autowired BookRepository bookRepository) {
        Iterable<Book> books = bookRepository.findAll();

        Assertions.assertThat(books)
            .extracting(Book::getTitle)
            .contains("mend", "weed");
    }

}
