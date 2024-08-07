package com.example.springboot.repositories;

import com.example.springboot.models.VinhoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VinhoReposirory extends JpaRepository<VinhoModel,Long> {
    @Query(value = "select * from tb_vinhos where data_compra >= 'data' order by data_compra asc ", nativeQuery = true)
    List<VinhoModel> findAllByDataCompra(@Param("data_comra") Date data_compra);

    @Query(value = "select * from tb_vinhos where codigo_vinho_id = ?",nativeQuery = true)
    List<VinhoModel>findById2(@Param("codigo_vinho_id") Long codigo_vinho_id);
}
