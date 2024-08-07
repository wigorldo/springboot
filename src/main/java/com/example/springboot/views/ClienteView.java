package com.example.springboot.views;

import org.springframework.format.number.money.MonetaryAmountFormatter;

import java.math.BigDecimal;
import java.util.UUID;

public interface ClienteView {
    UUID getCodigoCliente();
    String getCpf();
    String getNome();
    BigDecimal getValorTotalCompras();
}
