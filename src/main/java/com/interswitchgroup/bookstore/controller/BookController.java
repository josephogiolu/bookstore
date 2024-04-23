package com.interswitchgroup.bookstore.controller;

import com.interswitchgroup.bookstore.dto.ApiResponse;
import com.interswitchgroup.bookstore.model.Book;
import com.interswitchgroup.bookstore.service.impl.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Tag(name = "Book", description = "Book Api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public  ResponseEntity<ApiResponse<List<Book>>>  getAllBooks() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body( new ApiResponse<>(true, HttpStatus.OK.toString(),"SUCCESS", bookService.getAllBooks()));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(false,ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), null));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Book>> addBook(@Valid  @RequestBody Book book){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body( new ApiResponse<>(true, HttpStatus.CREATED.toString(),"SUCCESS", bookService.addBook(book)));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(false,ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>>  getBookById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body( new ApiResponse<>(true, HttpStatus.OK.toString(),"SUCCESS", bookService.getBookById(id)));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(false,ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), null));
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> updateBook(@PathVariable Long id, @RequestBody Book book) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body( new ApiResponse<>(true, HttpStatus.CREATED.toString(),"SUCCESS", bookService.updateBook(id, book)));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(false, HttpStatus.INTERNAL_SERVER_ERROR.toString(),ex.getMessage(), null));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>>  deleteBook(@PathVariable Long id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.CREATED).body( new ApiResponse<>(true, HttpStatus.CREATED.toString(),"SUCCESS", null));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(false, HttpStatus.INTERNAL_SERVER_ERROR.toString(),ex.getMessage(), null));
        }

    }
}