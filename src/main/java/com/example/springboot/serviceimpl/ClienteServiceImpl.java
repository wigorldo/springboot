package com.example.springboot.serviceimpl;

import com.example.springboot.dtos.ClienteDto;
import com.example.springboot.models.ClienteModel;
import com.example.springboot.repositories.ClienteRepository;
import com.example.springboot.services.ClienteService;
import com.example.springboot.views.ClienteView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<ClienteView> buscarTop3ClientesFieis() {
        List<ClienteView> clienteViews = null;
        try {
            clienteViews = clienteRepository.findTop3ClientesFieis();
            if (clienteViews.isEmpty()) {
                throw new IllegalArgumentException("Lista não encontrada");
            }
            if (clienteViews.size() < 3) {
                throw new IllegalArgumentException("Não foi cadastrado 3 clientes ainda");
            }
        } catch (DataAccessException e) {
            System.out.println("Erro" + e.getMessage());
        } finally {
            return clienteViews;
        }
    }

    @Override
    @Transactional
    public ClienteModel saveCliente(ClienteDto clienteDto){
        ClienteModel client = new ClienteModel();
        List<ClienteModel>clienteModels = null;
        clienteModels = clienteRepository.findAllByCpf(clienteDto.cpf());
        if(clienteModels.isEmpty()){
            client.setCpf(clienteDto.cpf());
            client.setNome(clienteDto.nome());
        }
        try{
            clienteRepository.save(client);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Erro ao salvar Cliente"+e.getMessage());
        }
        return client;
    }
}
