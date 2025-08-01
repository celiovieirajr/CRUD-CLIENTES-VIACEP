package com.example.demo.controller;

import com.example.demo.model.ViaCep;
import com.example.demo.service.ViaCepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("viacep")
public class ViaCepController {

    private final ViaCepService viaCepService;

    public ViaCepController(ViaCepService viaCepService) {
        this.viaCepService = viaCepService;
    }

    @GetMapping("{cep}")
    public ViaCep buscarEnderecoPorCepController(@PathVariable String cep) {
        return viaCepService.buscarEnderecoPorCep(cep);
    }
}
