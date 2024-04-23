package com.interswitchgroup.bookstore;


import com.interswitchgroup.bookstore.model.Book;
import com.interswitchgroup.bookstore.repository.BookRepository;
import com.interswitchgroup.bookstore.service.impl.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBooks() {
        // Given
        List<Book> expectedBooks = Arrays.asList(
                new Book(122L,"Title 1", "Thriller", "12345", "Author 1", 2022),
                new Book(233L,"Title 2", "Mystery", "67890", "Author 2", 2021)
        );
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // When
        List<Book> actualBooks = bookService.getAllBooks();

        // Then
        assertEquals(expectedBooks.size(), actualBooks.size());
        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    void testAddBook() {
        // Given
        Book bookToAdd = new Book(234L,"New Book", "Horror", "54321", "New Author", 2023);
        when(bookRepository.save(bookToAdd)).thenReturn(bookToAdd);

        // When
        Book addedBook = bookService.addBook(bookToAdd);

        // Then
        assertEquals(bookToAdd, addedBook);
    }

    @Test
    void testGetBookById() {
        // Given
        Long bookId = 234L;
        Book expectedBook = new Book(234L,"Title", "Genre", "12345", "Author", 2022);
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(expectedBook));

        // When
        Book actualBook = bookService.getBookById(bookId);

        // Then
        assertEquals(expectedBook, actualBook);
    }

    // Similarly, write tests for updateBook and deleteBook methods
}
