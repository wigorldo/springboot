package com.example.springboot.views;

import com.example.springboot.enums.TipoVinhoEnum;

import java.math.BigDecimal;
import java.sql.Date;


public interface CompraView {
        String getNome();
        String getCpf();
        Double getValorTotal();
        Long getCodigoVinhoId();
        TipoVinhoEnum getTipoVinhoEnum();
        Date getDataCompra();
        Date getSafra();
        BigDecimal getPreco();
}
