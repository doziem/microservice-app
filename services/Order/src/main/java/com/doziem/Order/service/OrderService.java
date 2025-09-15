package com.doziem.Order.service;

import com.doziem.Order.OrderLine.OrderLineRequest;
import com.doziem.Order.OrderLine.OrderLineService;
import com.doziem.Order.customer.CustomerClient;
import com.doziem.Order.exception.BusinessException;
import com.doziem.Order.kafka.OrderConfirmation;
import com.doziem.Order.kafka.OrderProducer;
import com.doziem.Order.order.OrderMapper;
import com.doziem.Order.order.OrderRepository;
import com.doziem.Order.order.OrderRequest;
import com.doziem.Order.order.OrderResponse;
import com.doziem.Order.payment.PaymentClient;
import com.doziem.Order.payment.PaymentRequest;
import com.doziem.Order.product.ProductClient;
import com.doziem.Order.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;


    public String  createOrder(OrderRequest request) {

        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided ID"));

      var purchaseProducts =  this.productClient.purchaseProduct(request.products());

        var order = this.repository.save(mapper.toOrder(request));

        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getOrderId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        var payment = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                order.getOrderId(),
                order.getReference(),
                customer
        );

paymentClient.requestOrderPayment(payment);

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchaseProducts
                )
        );
        return "Order Placed Successfully";
    }

    public List<OrderResponse> findAllOrders() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(String  id) {
        return this.repository.findById(id)
                .map(this.mapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided ID: %d", id)));
    }
}
