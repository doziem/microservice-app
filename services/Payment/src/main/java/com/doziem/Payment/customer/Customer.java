package com.doziem.Payment.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record Customer(
    String customerId,
    @NotNull(message = "Firstname is required")
    String firstname,
    @NotNull(message = "Lastname is required")
    String lastname,
    @NotNull(message = "Email is required")
    @Email(message = "The customer email formated correctly")
    String email)
{
}
