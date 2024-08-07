package com.example.springboot.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Data
@ToString(exclude = {"cliente","vinhos"})
@Entity
@Table(name = "TB_CLIENTE_COMPRAS")
public class CompraModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID compra_id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    @Column
    private int quantidade;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "TB_CLIENTE_COMPRAS",
            joinColumns = @JoinColumn(name = "compra_id"),
            inverseJoinColumns = @JoinColumn(name = "codigoVinhoId")
    )
    private List<VinhoModel> vinhos;

}
