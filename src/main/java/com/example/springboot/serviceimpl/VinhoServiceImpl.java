package com.example.springboot.serviceimpl;

import com.example.springboot.dtos.VinhosDto;
import com.example.springboot.models.VinhoModel;
import com.example.springboot.repositories.VinhoReposirory;
import com.example.springboot.services.VinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class VinhoServiceImpl implements VinhoService {
    @Autowired
    VinhoReposirory vinhoReposirory;

    @Override
    public VinhoModel saveVinho(VinhosDto vinhosDto) {
        VinhoModel vinhoModel = new VinhoModel();
        vinhoModel.setCodigoVinhoId(vinhosDto.codigo_vinho());
        vinhoModel.setTipoVinhoEnum(vinhosDto.tipo_vinho());
        vinhoModel.setSafra(Year.of(vinhosDto.safra().getYear()));
        vinhoModel.setPreco(vinhosDto.preco());
        vinhoModel.setDataCompra(Year.of(vinhosDto.ano_compra().getYear()));
        try{
            vinhoReposirory.save(vinhoModel);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Erro ao Salvar novo vinho: "+e.getMessage());
        }
        return vinhoModel;
    }
}
