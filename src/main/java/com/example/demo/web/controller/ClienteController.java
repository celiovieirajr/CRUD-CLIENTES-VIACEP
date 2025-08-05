package com.example.demo.web.controller;

import com.example.demo.service.ClienteService;
import com.example.demo.web.dto.ClienteRequestDto;
import com.example.demo.web.dto.ClienteResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ClienteResponseDto criarClienteController(@RequestBody ClienteRequestDto requestDto) {
        return clienteService.criarCliente(requestDto);
    }

    @GetMapping
    public List<ClienteResponseDto> listarClienteController() {
        return clienteService.listarClientes();
    }

    @GetMapping("{id}")
    public ClienteResponseDto buscaClientePorId(@PathVariable long id) {
        return clienteService.buscaClientePorId(id);
    }

    @PutMapping("{id}")
    public ClienteResponseDto editarClienteController(@PathVariable long id,
                                                      @RequestBody ClienteRequestDto requestDto) {
        return clienteService.editarCliente(id, requestDto);
    }

    @DeleteMapping("{id}")
    public void deletarClientePorId(@PathVariable long id) {
        clienteService.deletarClientePorId(id);
    }


}
