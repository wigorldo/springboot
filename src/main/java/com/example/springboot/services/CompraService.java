package com.example.springboot.services;

import com.example.springboot.dtos.CompraDto;
import com.example.springboot.models.CompraModel;
import com.example.springboot.views.CompraView;

import java.time.Year;
import java.util.List;
import java.util.UUID;


public interface CompraService {
    List<CompraView> buscarCompras();
    CompraView buscarMaiorCompraPorAno(Year ano);

    CompraModel saveCompra(CompraDto compraDto);
}
