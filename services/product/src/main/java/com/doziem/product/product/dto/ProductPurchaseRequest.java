package com.doziem.product.product.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductPurchaseRequest(
        @NotNull(message = "Product is mandatory")
        String productId,
        @Positive(message = "Quantity is mandatory")
        double quantity
) {
}
