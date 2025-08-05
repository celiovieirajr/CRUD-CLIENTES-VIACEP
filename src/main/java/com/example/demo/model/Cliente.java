package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
<<<<<<< HEAD
=======
@Table(name = "CLIENTE")
>>>>>>> beaf508c110cf88d88e9acf7758970ce30a29b41
@Getter
@Setter
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
<<<<<<< HEAD
    private Timestamp ultimaDataModificada;

    @Embedded
    private ViaCep endereco;
=======
    private Timestamp dataAtualizacao;

    @Embedded
    private ViaCep endereco;

>>>>>>> beaf508c110cf88d88e9acf7758970ce30a29b41
}
