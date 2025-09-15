package com.doziem.Order.order;

import java.math.BigDecimal;

public record OrderResponse(
        String orderId,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerId
) {

}
