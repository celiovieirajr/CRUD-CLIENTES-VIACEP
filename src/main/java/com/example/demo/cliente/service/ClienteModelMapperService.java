package com.example.demo.cliente.service;

import com.example.demo.cliente.model.Cliente;
import com.example.demo.cliente.dto.ClienteRequestDto;
import com.example.demo.cliente.dto.ClienteResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ClienteModelMapperService {

    @Autowired
    private ModelMapper modelMapper;

    public Cliente toModel(ClienteRequestDto request) {
        Cliente model = modelMapper.map(request, Cliente.class);
        model.setUltimaDataModificada(new Timestamp(System.currentTimeMillis()));
        return model;
    }

    public ClienteResponseDto toResponse(Cliente model) {
        return modelMapper.map(model, ClienteResponseDto.class);
    }
}
