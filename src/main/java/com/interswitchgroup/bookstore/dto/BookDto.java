package com.interswitchgroup.bookstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {

    private String title;

    private String genre;

    private String isbn;

    private String author;

    private int publicationYear;
}
