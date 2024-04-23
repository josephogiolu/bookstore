package com.interswitchgroup.bookstore;

import com.interswitchgroup.bookstore.model.Book;
import com.interswitchgroup.bookstore.repository.BookRepository;
import com.interswitchgroup.bookstore.service.impl.SearchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class SearchServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private SearchService searchService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSearchBooksByTitle() {
        // Given
        String title = "Title";
        List<Book> expectedBooks = Arrays.asList(
                new Book(344L,"Title 1", "Thriller", "12345", "Author 1", 2022),
                new Book(543L,"Title 2", "Mystery", "67890", "Author 2", 2021)
        );
        when(bookRepository.findByTitleContainingIgnoreCase(title)).thenReturn(expectedBooks);

        // When
        List<Book> actualBooks = searchService.searchBooksByTitle(title);

        // Then
        assertEquals(expectedBooks.size(), actualBooks.size());
        assertEquals(expectedBooks, actualBooks);
    }

    // Similarly, write tests for searchBooksByAuthor, searchBooksByPublicationYear, and searchBooksByGenre methods
}