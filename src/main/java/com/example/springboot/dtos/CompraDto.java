package com.example.springboot.dtos;

import java.util.List;

public record CompraDto(String cpf, List<ItemCompras> itens) {
    public record ItemCompras(Long codigoVinhoId,Integer quantidade){

    }
}
