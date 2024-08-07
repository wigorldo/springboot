package com.example.springboot.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteDto(@NotBlank String nome,
                         @NotNull String cpf) {
}
