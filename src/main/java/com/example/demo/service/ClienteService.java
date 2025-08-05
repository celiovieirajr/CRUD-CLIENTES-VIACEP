package com.example.demo.service;

<<<<<<< HEAD
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.web.dto.ClienteRequestDto;
import com.example.demo.web.dto.ClienteResponseDto;
=======
import com.example.demo.dto.ClienteRequest;
import com.example.demo.dto.ClienteResponse;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
>>>>>>> beaf508c110cf88d88e9acf7758970ce30a29b41
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

<<<<<<< HEAD
@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteModelMapperService clienteModelMapperService;
    private final ClienteRepository clienteRepository;



    public ClienteResponseDto criarCliente(ClienteRequestDto requestDto) {
        Cliente model = clienteModelMapperService.toModel(requestDto);
        Cliente modelSave = clienteRepository.save(model);

        return clienteModelMapperService.toResponse(modelSave);
    }

    public List<ClienteResponseDto> listarClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteModelMapperService::toResponse)
                .collect(Collectors.toList());
    }

    public ClienteResponseDto buscaClientePorId(long id) {
        Cliente model = clienteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não foi encontrado com o id: " + id));

        return clienteModelMapperService.toResponse(model);
    }

    public ClienteResponseDto editarCliente(long id, ClienteRequestDto clienteRequestDto) {
        Cliente clienteId = clienteRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado com o id: " + id));

        clienteId.setUltimaDataModificada(new Timestamp(System.currentTimeMillis()));
        clienteId.setEndereco(clienteRequestDto.getEndereco());
        clienteId.setNome(clienteRequestDto.getNome());

        Cliente clienteSalvo = clienteRepository.save(clienteId);
        return clienteModelMapperService.toResponse(clienteSalvo);
    }

    public void deletarClientePorId(long id) {
        Cliente clienteDeletado = clienteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado com o id: " + id));

        clienteRepository.delete(clienteDeletado);
    }


=======
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
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não foi encontrado" + id));
    }


    public ClienteResponse atualizarCliente(Long id, ClienteRequest request) {
        Cliente model = clienteRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado pelo ID: " + id)
        );

        model.setNome(request.getNome());
        model.setEndereco(request.getEndereco());
        model.setDataAtualizacao(new Timestamp(System.currentTimeMillis()));

        Cliente clienteAtualizado = clienteRepository.save(model);

        return toResponse(clienteAtualizado);
    }

    public void deletarCliente(Long id) {
        Cliente clienteId = clienteRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado pelo ID: " + id)
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
>>>>>>> beaf508c110cf88d88e9acf7758970ce30a29b41
}
