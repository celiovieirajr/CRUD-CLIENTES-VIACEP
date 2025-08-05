package com.example.demo.cliente.controller;

import com.example.demo.viacep.ViaCepWebClient;
import com.example.demo.cliente.model.ViaCep;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viacep")
@AllArgsConstructor
public class ViaCepController {

    private final ViaCepWebClient viaCepWebClient;

    @GetMapping("/{cep}")
    public ViaCep getViaCepController(@PathVariable String cep) {
        return viaCepWebClient.getViaCep(cep);
    }

}
