package com.example.demo.service;

import com.example.demo.model.ViaCep;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ViaCepService {

    private final WebClient webClient;

    public ViaCepService(WebClient webClient) {
        this.webClient = webClient;
    }

    public ViaCep buscarEnderecoPorCep(String cep) {
        return webClient.get()
                        .uri(cep + "/json/")
                        .retrieve()
                        .bodyToMono(ViaCep.class)
                        .block();
    }
}
