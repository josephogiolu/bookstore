package com.interswitchgroup.bookstore.service.impl;

import com.interswitchgroup.bookstore.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceFactory {

    @Autowired
    private RemitaService remitaService;

    @Autowired
    private InterSwitchService interSwitchService;

    @Autowired
    private StripeService stripeService;

    public PayService getPaymentService(String gateway) {
        switch (gateway) {
            case "remita":
                return remitaService;
            case "interswitch":
                return interSwitchService;
            case "stripe":
                return stripeService;
            default:
                throw new IllegalArgumentException("Invalid payment gateway: " + gateway);
        }
    }
}