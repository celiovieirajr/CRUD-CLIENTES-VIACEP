package com.example.demo.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ViaCep {

    private String cep;
    private String logradouro;
    private String localidade;
    private String estado;
    private String regiao;

}
