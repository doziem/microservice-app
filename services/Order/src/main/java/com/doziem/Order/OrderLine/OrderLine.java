package com.doziem.Order.OrderLine;

import com.doziem.Order.order.Order;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "customer_line")
public class OrderLine {
    @Id
    @GeneratedValue
    private String orderLineId;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private String productId;
    private double quantity;
}
