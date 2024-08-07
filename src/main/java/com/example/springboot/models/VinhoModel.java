package com.example.springboot.models;

import com.example.springboot.enums.TipoVinhoEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Year;
import java.util.Date;

@Entity
@Data
@Table(name = "TB_VINHOS")
public class VinhoModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoVinhoId;

    @Enumerated(EnumType.ORDINAL)
    private TipoVinhoEnum tipoVinhoEnum;

    @Column(name = "data_compra")
    private Year dataCompra;

    @Column(name="safra")
    private Year safra;

    @Column(name = "preco")
    private BigDecimal preco;
}
