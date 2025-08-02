package com.example.demo.dto;

import com.example.demo.model.ViaCep;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ClienteResponse {

    private long id;
    private String nome;
    private Timestamp dataAtualizacao;
    private ViaCep endereco;

}
