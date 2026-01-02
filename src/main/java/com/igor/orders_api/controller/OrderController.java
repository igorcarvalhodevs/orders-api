package com.igor.orders_api.controller;

import com.igor.orders_api.dto.CreateOrderRequest;
import com.igor.orders_api.dto.OrderResponse;
import com.igor.orders_api.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @Operation(summary = "Create a new order")
    @ApiResponse(responseCode = "201", description = "Created")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse create(@Valid @RequestBody CreateOrderRequest request) {
        return service.create(request);
    }

    @Operation(summary = "Get order by id")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @GetMapping("/{id}")
    public OrderResponse getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public Page<OrderResponse> list(
            @ParameterObject
            @PageableDefault(size = 20, sort = "createdAt")
            Pageable pageable
    ) {
        return service.findAll(pageable);
    }
}

