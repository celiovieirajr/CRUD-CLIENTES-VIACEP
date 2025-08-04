package com.example.demo.dto;

import com.example.demo.model.ViaCep;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class ClienteRequest {

    private String nome;
    private Timestamp dataAtualizacao;
    private ViaCep endereco;

}
