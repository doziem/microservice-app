package com.doziem.Order.kafka;

import com.doziem.Order.customer.CustomerResponse;
import com.doziem.Order.order.PaymentMethod;
import com.doziem.Order.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
