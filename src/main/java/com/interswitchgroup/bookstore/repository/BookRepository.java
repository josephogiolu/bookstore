package com.interswitchgroup.bookstore.repository;

import com.interswitchgroup.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByAuthorContainingIgnoreCase(String author);

    List<Book> findByPublicationYear(int year);

    List<Book> findByGenreIgnoreCase(String genre);

}