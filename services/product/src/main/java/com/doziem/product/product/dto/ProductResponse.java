package com.doziem.product.product.dto;

import java.math.BigDecimal;

public record ProductResponse(
        String productId,
        String name,
        String description,
        double availableQuantity,
        BigDecimal price,
        Integer categoryId,
        String categoryName,
        String categoryDescription
) {
}
