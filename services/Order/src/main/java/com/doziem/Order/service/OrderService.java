package com.doziem.Order.service;

import com.doziem.Order.customer.CustomerClient;
import com.doziem.Order.order.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    public Integer createOrder(OrderRequest request) {

       return null;
    }
}
