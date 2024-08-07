package com.example.springboot.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "TB_CLIENTE")
public class ClienteModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private UUID cliente_id;

    @Column(unique = true)
    private String cpf;

    @Column(unique = false)
    private String nome;


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<CompraModel> compras;

}
