package com.interswitchgroup.bookstore.controller;

import com.interswitchgroup.bookstore.dto.ApiResponse;
import com.interswitchgroup.bookstore.model.Book;
import com.interswitchgroup.bookstore.model.ShoppingCart;
import com.interswitchgroup.bookstore.service.impl.ShoppingCartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-cart")
@RequiredArgsConstructor
@Tag(name = "Shopping Cart", description = "Shopping Cart Api")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ShoppingCart> > createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        var response = shoppingCartService.createShoppingCart(shoppingCart);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body( new ApiResponse<>(true, HttpStatus.CREATED.toString(),"SUCCESS", response));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(false,ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), null));
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getShoppingCart(@PathVariable Long id) {
        return shoppingCartService.getShoppingCart(id)
                .map(cart -> new ResponseEntity<>(cart, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{cartId}/add")
    public ResponseEntity<ApiResponse<ShoppingCart>> addToCart(@PathVariable Long cartId, @RequestBody Book book) {
        ShoppingCart shoppingCart = shoppingCartService.addToCart(cartId, book);
        try {
            return ResponseEntity.status(HttpStatus.OK).body( new ApiResponse<>(true, HttpStatus.OK.toString(),"SUCCESS", shoppingCart));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(false,ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), null));
        }

    }


    @PostMapping("/{cartId}/remove")
    public ResponseEntity<ApiResponse<ShoppingCart>> removeFromCart(@PathVariable Long cartId, @RequestBody Book book) {
        ShoppingCart shoppingCart = shoppingCartService.removeFromCart(cartId, book);
        try {
            return ResponseEntity.status(HttpStatus.OK).body( new ApiResponse<>(true, HttpStatus.OK.toString(),"SUCCESS", shoppingCart));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(false,ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), null));
        }

    }


}