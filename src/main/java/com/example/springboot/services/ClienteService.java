package com.example.springboot.services;

import com.example.springboot.dtos.ClienteDto;
import com.example.springboot.models.ClienteModel;
import com.example.springboot.views.ClienteView;

import java.util.List;

public interface ClienteService {
    List<ClienteView> buscarTop3ClientesFieis();
    ClienteModel saveCliente(ClienteDto clienteDto);
}
