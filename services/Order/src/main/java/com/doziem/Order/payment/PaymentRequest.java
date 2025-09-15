package com.doziem.Order.payment;

import com.doziem.Order.customer.CustomerResponse;
import com.doziem.Order.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String  orderId,
        String orderReference,
        CustomerResponse customer
) {
}
