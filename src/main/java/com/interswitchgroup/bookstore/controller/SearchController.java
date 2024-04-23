package com.interswitchgroup.bookstore.controller;

import com.interswitchgroup.bookstore.dto.ApiResponse;
import com.interswitchgroup.bookstore.model.Book;
import com.interswitchgroup.bookstore.service.impl.SearchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
@Tag(name = "Search", description = "Search Api")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping("/title")
    public ResponseEntity<ApiResponse<List<Book>>> searchBooksByTitle(@RequestParam String title) {
        var books = searchService.searchBooksByTitle(title);
        try {
            return ResponseEntity.status(HttpStatus.OK).body( new ApiResponse<>(true, HttpStatus.OK.toString(),"SUCCESS", books));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(false,ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), null));
        }

    }

    @GetMapping("/author")
    public ResponseEntity<ApiResponse<List<Book>>> searchBooksByAuthor(@RequestParam String author) {
      var books = searchService.searchBooksByAuthor(author);
        try {
            return ResponseEntity.status(HttpStatus.OK).body( new ApiResponse<>(true, HttpStatus.OK.toString(),"SUCCESS", books));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(false,ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), null));
        }

    }

    @GetMapping("/year")
    public ResponseEntity<ApiResponse<List<Book>>> searchBooksByPublicationYear(@RequestParam int year) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body( new ApiResponse<>(true, HttpStatus.OK.toString(),"SUCCESS", searchService.searchBooksByPublicationYear(year)));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(false,ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), null));
        }

    }

    @GetMapping("/genre")
    public ResponseEntity<ApiResponse<List<Book>>> searchBooksByGenre(@RequestParam String genre) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body( new ApiResponse<>(true, HttpStatus.OK.toString(),"SUCCESS", searchService.searchBooksByGenre(genre)));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(false,ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), null));
        }

    }


}
