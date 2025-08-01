package com.example.demo.dto;

import com.example.demo.model.ViaCep;

import java.sql.Timestamp;

public class ClienteRequest {

    private String nome;
    private Timestamp dataAtualizacao;
    private ViaCep endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Timestamp getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public ViaCep getEndereco() {
        return endereco;
    }

    public void setEndereco(ViaCep endereco) {
        this.endereco = endereco;
    }
}
