package com.example.demo.cliente.dto;

import com.example.demo.cliente.model.ViaCep;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ClienteResponseDto {

    private long id;
    private String nome;
    private Timestamp ultimaDataModificada;
    private ViaCep endereco;
}
