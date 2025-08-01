package com.example.demo.controller;

import com.example.demo.dto.ClienteRequest;
import com.example.demo.dto.ClienteResponse;
import com.example.demo.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ClienteResponse criarClienteController(@RequestBody ClienteRequest clienteRequest) {
        return clienteService.criarCliente(clienteRequest);
    }

    @GetMapping
    public List<ClienteResponse> listarClienteController() {
        return clienteService.listarCliente();
    }

    @GetMapping("/{id}")
    public ClienteResponse listaClientePorIdController(@PathVariable Long id) {
        return clienteService.listaClientePorId(id);
    }

    @PutMapping("/{id}")
    public ClienteResponse atualizaClienteController(@PathVariable Long id,
                                                     @RequestBody ClienteRequest request) {
        return clienteService.atualizarCliente(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletarClienteController(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }
}
