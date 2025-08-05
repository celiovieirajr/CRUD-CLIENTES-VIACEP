package com.example.demo.cliente.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "CLIENTE")
@Getter
@Setter
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Timestamp ultimaDataModificada;

    @Embedded
    private ViaCep endereco;

}
