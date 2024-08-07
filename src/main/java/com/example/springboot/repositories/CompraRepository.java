package com.example.springboot.repositories;

import com.example.springboot.models.CompraModel;
import com.example.springboot.views.CompraView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Year;
import java.util.List;

public interface CompraRepository extends JpaRepository<CompraModel, Long> {
    @Query(value = "select c.nome,c.cpf,v.*,cc.quantidade, cc.quantidade * v.preco as \"ValorTotal\" from tb_cliente_compras as cc\n" +
            "inner join tb_cliente as c\n" +
            "on cc.cliente_id = c.cliente_id\n" +
            "inner join tb_vinhos v\n" +
            "on v.codigo_vinho_id = cc.codigo_vinho_id order by cc.quantidade * v.preco asc",nativeQuery = true)
    List<CompraView> findAllCompras();

    @Query(value = "select  c.nome,c.cpf,v.*,cc.quantidade, cc.quantidade * v.preco as \"ValorTotal\" from tb_cliente_compras as cc\n" +
            "inner join tb_cliente as c\n" +
            "on cc.cliente_id = c.cliente_id\n" +
            "inner join tb_vinhos v\n" +
            "on v.codigo_vinho_id = cc.codigo_vinho_id \n" +
            "where extract(YEAR FROM v.data_compra) = ?\n" +
            "order by cc.quantidade * v.preco desc\n" +
            "Limit 1",nativeQuery = true)
    CompraView findByMaiorCompraPorAno(@Param("ano")Year ano);

}


