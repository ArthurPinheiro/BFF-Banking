package com.baking.bff.model;

import jakarta.validation.constraints.Size;

public record Client(
        @Size(min = 11, max = 11, message = "O CPF deve conter exatamente 11 digitos")
        String cpf) {}
