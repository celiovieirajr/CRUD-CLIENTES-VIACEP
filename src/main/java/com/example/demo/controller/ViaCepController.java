package com.example.demo.controller;

import com.example.demo.model.ViaCep;
import com.example.demo.ingestion.ViaCepGetCep;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("viacep")
public class ViaCepController {

    private final ViaCepGetCep viaCepGetCep;

    @GetMapping("{cep}")
    public ViaCep buscarEnderecoPorCepController(@PathVariable String cep) {
        return viaCepGetCep.buscarEnderecoPorCep(cep);
    }
}
