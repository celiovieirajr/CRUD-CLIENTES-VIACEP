package com.example.demo.web.dto;

import com.example.demo.model.ViaCep;
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
