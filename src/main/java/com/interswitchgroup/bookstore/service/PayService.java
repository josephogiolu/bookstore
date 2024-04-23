package com.interswitchgroup.bookstore.service;

import com.interswitchgroup.bookstore.dto.CallbackRequest;
import com.interswitchgroup.bookstore.dto.PaymentRequest;
import com.interswitchgroup.bookstore.dto.WebhookRequest;

public interface PayService {
    String processPayment(PaymentRequest request);

    void handleWebhook(WebhookRequest webhookRequest);

    void handleCallback(CallbackRequest callbackRequest);
}
