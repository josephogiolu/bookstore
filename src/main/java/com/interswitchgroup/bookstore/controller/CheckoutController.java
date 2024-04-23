package com.interswitchgroup.bookstore.controller;

import com.interswitchgroup.bookstore.dto.ApiResponse;
import com.interswitchgroup.bookstore.service.CheckoutService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "Checkout", description = "Checkout Api")
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>> checkout(@RequestParam double amount, @RequestParam String paymentMethod) {
        boolean paymentStatus = checkoutService.processPayment(amount, paymentMethod);
        if (paymentStatus) {
            return  ResponseEntity.status(HttpStatus.CREATED).body( new ApiResponse<>(true, HttpStatus.CREATED.toString(),"SUCCESS", "Payment successful!"));
        } else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body( new ApiResponse<>(false, HttpStatus.BAD_REQUEST.toString(),"ERROR", "Payment failed. Invalid payment method!"));

        }
    }
}