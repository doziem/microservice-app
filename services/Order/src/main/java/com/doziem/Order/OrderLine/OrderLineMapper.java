package com.doziem.Order.OrderLine;

import com.doziem.Order.order.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .orderLineId(request.orderId())
                .productId(request.productId())
                .quantity(request.quantity())
                .order(
                        Order.builder()
                                .orderId(request.orderId())
                                .build()
                )
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(
                orderLine.getOrderLineId(),
                orderLine.getQuantity()
        );
    }
}
