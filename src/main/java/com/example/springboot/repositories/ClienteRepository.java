package com.example.springboot.repositories;

import com.example.springboot.models.ClienteModel;
import com.example.springboot.views.ClienteView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    @Query(value = "SELECT c.cliente_id as \tCodigoCliente,c.cpf as CPF,c.nome , SUM(cc.quantidade * v.preco) AS valorTotalCompras fROM tb_cliente c\n" +
            "INNER JOIN tb_cliente_compras cc\n" +
            "on c.cliente_id = cc.cliente_id\n" +
            "INNER JOIN tb_vinhos v\n" +
            "on v.codigo_vinho_id = cc.codigo_vinho_id\n" +
            "GROUP BY c.cliente_id\n" +
            "ORDER BY valorTotalCompras DESC\n" +
            "limit 3",nativeQuery = true)
    List<ClienteView> findTop3ClientesFieis();

    @Query(value = "select * from tb_cliente order by cliente_id desc limit 1\n",nativeQuery = true)
    ClienteModel findByUltimoClienteId();
    List<ClienteModel> findAllByCpf(String cpf);

    Optional<ClienteModel> findByCpf(String cpf);


}

