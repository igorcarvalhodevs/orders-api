package com.igor.orders_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record CreateOrderRequest(
    @NotBlank(message = "customerEmail é obrigatório")
    @Email(message = "customerEmail deve ser um e-mail válido")
    String customerEmail,

    @NotNull(message = "totalCents é obrigatório")
    @PositiveOrZero(message = "totalCents deve ser maior ou igual a 0")
    Long totalCents
) {}

