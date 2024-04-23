package com.interswitchgroup.bookstore.service.impl;

import com.interswitchgroup.bookstore.model.Book;
import com.interswitchgroup.bookstore.model.ShoppingCart;
import com.interswitchgroup.bookstore.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCart createShoppingCart( ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    public Optional<ShoppingCart> getShoppingCart(Long id) {
        return shoppingCartRepository.findById(id);
    }

    public ShoppingCart addToCart(Long cartId, Book book) {
        Optional<ShoppingCart> optionalShoppingCart = shoppingCartRepository.findById(cartId);
        if (optionalShoppingCart.isPresent()) {
            ShoppingCart shoppingCart = optionalShoppingCart.get();
            shoppingCart.getBooks().add(book);
            return shoppingCartRepository.save(shoppingCart);
        } else {
            throw new IllegalArgumentException("Shopping cart not found with id: " + cartId);
        }
    }

    public ShoppingCart removeFromCart(Long cartId, Book book) {
        Optional<ShoppingCart> optionalShoppingCart = shoppingCartRepository.findById(cartId);
        if (optionalShoppingCart.isPresent()) {
            ShoppingCart shoppingCart = optionalShoppingCart.get();
            shoppingCart.getBooks().remove(book);
            return shoppingCartRepository.save(shoppingCart);
        } else {
            throw new IllegalArgumentException("Shopping cart not found with id: " + cartId);
        }
    }

    // Other methods as needed
}
