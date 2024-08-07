package com.example.springboot.views;

import com.example.springboot.enums.TipoVinhoEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.Year;

public interface VinhoView {
    Long getCodigoVinhoId();
    TipoVinhoEnum getTipoVinhoEnum();
    Year getDataCompra();
    Year getSafra();
    BigDecimal getPreco();

}
