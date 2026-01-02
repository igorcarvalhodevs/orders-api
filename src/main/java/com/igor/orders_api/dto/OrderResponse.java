package com.igor.orders_api.dto;

import java.time.Instant;

public record OrderResponse(
        Long id,
        String customerEmail,
        Long totalCents,
        Instant createdAt
) {}

