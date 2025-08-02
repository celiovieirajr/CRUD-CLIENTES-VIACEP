package com.example.demo.controller;

import com.example.demo.model.ViaCep;
import com.example.demo.ingestion.ViaCepService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("viacep")
public class ViaCepController {

    private final ViaCepService viaCepService;

    @GetMapping("{cep}")
    public ViaCep buscarEnderecoPorCepController(@PathVariable String cep) {
        return viaCepService.buscarEnderecoPorCep(cep);
    }
}
