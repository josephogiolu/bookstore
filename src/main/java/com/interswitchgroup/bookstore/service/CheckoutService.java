package com.interswitchgroup.bookstore.service;

import com.interswitchgroup.bookstore.service.impl.PaymentServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {
    @Autowired
   private  PaymentServiceFactory paymentServiceFactory;

    public boolean processPayment(double amount, String paymentMethod) {
        // Simulate payment process based on payment method
        switch (paymentMethod) {
            case "Web":
                paymentServiceFactory.getPaymentService(paymentMethod);
                return true; // Successful payment
            case "USSD":
                paymentServiceFactory.getPaymentService(paymentMethod);
                return true; // Successful payment
            case "Transfer":
                paymentServiceFactory.getPaymentService(paymentMethod);
                return true; // Successful payment
            default:
                return false; // Invalid payment method
        }
    }
}
