package com.example.springboot.serviceimpl;

import com.example.springboot.dtos.CompraDto;
import com.example.springboot.models.ClienteModel;
import com.example.springboot.models.CompraModel;
import com.example.springboot.models.VinhoModel;
import com.example.springboot.repositories.ClienteRepository;
import com.example.springboot.repositories.VinhoReposirory;
import com.example.springboot.views.CompraView;
import com.example.springboot.repositories.CompraRepository;
import com.example.springboot.services.CompraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;
import java.util.*;


@Service
public class CompraServiceImpl implements CompraService {
    private static final Logger log = LoggerFactory.getLogger(CompraService.class);

    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private VinhoReposirory vinhoReposirory;

    @Override
    public List<CompraView> buscarCompras() {

        return compraRepository.findAllCompras();
    }

    @Override
    public CompraView buscarMaiorCompraPorAno(Year ano) {
        try {
            return compraRepository.findByMaiorCompraPorAno(ano);
        } catch (DataAccessException e) {
            log.error("Erro ao buscar maior compra pelo ano informado", e);
            return null;
        }
    }

    @Override
    @Transactional
    public CompraModel saveCompra(CompraDto compraDto) {
        CompraModel compra = new CompraModel();
        List<VinhoModel> vinhos = new ArrayList<>();
        try {
            Optional<ClienteModel> cliente = clienteRepository.findByCpf(compraDto.cpf());
            if (cliente != null) {
                compra.setCliente(cliente.get());
                for (CompraDto.ItemCompras itemCompras : compraDto.itens()) {
                    vinhos = vinhoReposirory.findById2(itemCompras.codigoVinhoId());
                    if (!vinhos.isEmpty()) {
                        compra.setVinhos(vinhos);
                        compra.setQuantidade(itemCompras.quantidade());
                    } else {
                        throw new RuntimeException("Vinho com ID " + itemCompras.codigoVinhoId() + " não encontrado");
                    }
                }
            }
            compraRepository.save(compra);
        }catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Cliente não encontado na base de dados:  " + e);
        }


        return compra;
    }
}
