package com.example.demo.service;

import com.example.demo.dto.ClienteRequest;
import com.example.demo.dto.ClienteResponse;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;


    public ClienteResponse criarCliente(ClienteRequest request) {
        Cliente model = toModel(request);
        Cliente save = clienteRepository.save(model);
        return toResponse(save);
    }

    public List<ClienteResponse> listarCliente() {
        return clienteRepository.findAll()
                                .stream()
                                .map(this::toResponse)
                                .collect(Collectors.toList());
    }

    public ClienteResponse listaClientePorId(Long id) {
        return clienteRepository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    public ClienteResponse atualizarCliente(Long id, ClienteRequest request) {
        Cliente model = clienteRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")
        );

        model.setNome(request.getNome());
        model.setEndereco(request.getEndereco());
        model.setDataAtualizacao(new Timestamp(System.currentTimeMillis()));

        Cliente clienteAtualizado = clienteRepository.save(model);

        return toResponse(clienteAtualizado);
    }

    public void deletarCliente(Long id) {
        Cliente clienteId = clienteRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")
        );

        clienteRepository.delete(clienteId);
    }


    private Cliente toModel(ClienteRequest request) {
        Cliente model = new Cliente();
        model.setDataAtualizacao(new Timestamp(System.currentTimeMillis()));
        model.setNome(request.getNome());
        model.setEndereco(request.getEndereco());

        return model;
    }

    private ClienteResponse toResponse(Cliente model) {
        ClienteResponse response = new ClienteResponse();
        response.setId(model.getId());
        response.setEndereco(model.getEndereco());
        response.setNome(model.getNome());

        return response;
    }
}
