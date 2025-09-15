package com.doziem.Order.OrderLine;

public record OrderLineRequest(
        String  orderLineId,
        String orderId,
        String productId,
        double quantity
) {
}
