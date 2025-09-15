package com.doziem.Notification.kafka.order;

import java.math.BigDecimal;

public record Product(
        String  productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
