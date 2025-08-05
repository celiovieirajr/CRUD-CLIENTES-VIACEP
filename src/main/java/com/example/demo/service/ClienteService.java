package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.web.dto.ClienteRequestDto;
import com.example.demo.web.dto.ClienteResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

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


}
