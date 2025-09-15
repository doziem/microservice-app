package com.doziem.Payment.payment;

import com.doziem.Payment.customer.Customer;

import java.math.BigDecimal;

public record PaymentRequest(
        String paymentId,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String  orderId,
        String orderReference,
        Customer customer
) {
}
