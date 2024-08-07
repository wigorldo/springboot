package com.example.springboot.dtos;

import com.example.springboot.enums.TipoVinhoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public record VinhosDto(@NotBlank @NotNull Long codigo_vinho,
                        TipoVinhoEnum tipo_vinho,
                        @NotNull BigDecimal preco,
                        LocalDateTime safra,
                        LocalDateTime ano_compra
                        ) {
}
