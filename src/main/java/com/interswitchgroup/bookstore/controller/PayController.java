package com.interswitchgroup.bookstore.controller;

import com.interswitchgroup.bookstore.dto.PaymentRequest;
import com.interswitchgroup.bookstore.dto.WebhookRequest;
import com.interswitchgroup.bookstore.service.PayService;
import com.interswitchgroup.bookstore.service.impl.PaymentServiceFactory;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@Tag(name = "Payment", description = "Payment Api")
public class PayController {

    @Autowired
    private PaymentServiceFactory paymentServiceFactory;

    @PostMapping("/{gateway}")
    public ResponseEntity<String> processPayment(@PathVariable String gateway, @RequestBody PaymentRequest request) {
        PayService paymentService = paymentServiceFactory.getPaymentService(gateway);
        String response = paymentService.processPayment(request);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/webhook/{gateway}")
    public ResponseEntity<String> handleWebhook(
            @PathVariable String gateway,
            @RequestBody WebhookRequest webhookRequest) {
        PayService paymentService = paymentServiceFactory.getPaymentService(gateway);
        paymentService.handleWebhook(webhookRequest);
        return ResponseEntity.ok("Webhook handled successfully");
    }
}