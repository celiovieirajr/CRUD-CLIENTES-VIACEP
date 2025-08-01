package com.example.demo.dto;

import com.example.demo.model.ViaCep;

import java.sql.Timestamp;

public class ClienteResponse {

    private long id;
    private String nome;
    private Timestamp dataAtualizacao;
    private ViaCep endereco;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
