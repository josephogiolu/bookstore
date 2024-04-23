package com.interswitchgroup.bookstore.service.impl;

import com.interswitchgroup.bookstore.model.Book;
import com.interswitchgroup.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> searchBooksByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    public List<Book> searchBooksByPublicationYear(int year) {
        return bookRepository.findByPublicationYear(year);
    }

    public List<Book> searchBooksByGenre(String genre) {
        return bookRepository.findByGenreIgnoreCase(genre);
    }


}