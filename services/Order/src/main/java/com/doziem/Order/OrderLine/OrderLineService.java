package com.doziem.Order.OrderLine;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineService {
    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;

    public void saveOrderLine(OrderLineRequest request) {
        var order = mapper.toOrderLine(request);
        repository.save(order);
    }

    public List<OrderLineResponse> findAllByOrderId(String orderId) {
        return repository.findById(orderId)
                .stream()
                .map(mapper::toOrderLineResponse)
                .collect(Collectors.toList());
    }
}
