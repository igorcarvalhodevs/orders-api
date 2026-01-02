package com.igor.orders_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateOrderRequest(
        @NotBlank @Email String customerEmail,
        @NotNull @Min(0) Long totalCents
) {}

