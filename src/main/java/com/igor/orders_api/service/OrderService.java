package com.igor.orders_api.service;

import com.igor.orders_api.dto.CreateOrderRequest;
import com.igor.orders_api.dto.OrderResponse;
import com.igor.orders_api.entity.Order;
import com.igor.orders_api.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public OrderResponse create(CreateOrderRequest request) {
        Order order = new Order();
        order.setCustomerEmail(request.customerEmail());
        order.setTotalCents(request.totalCents());

        Order saved = repository.save(order);
        return toResponse(saved);
    }

    public OrderResponse findById(Long id) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return toResponse(order);
    }

    public Page<OrderResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(this::toResponse);
    }

    private OrderResponse toResponse(Order o) {
        return new OrderResponse(o.getId(), o.getCustomerEmail(), o.getTotalCents(), o.getCreatedAt());
    }
}

