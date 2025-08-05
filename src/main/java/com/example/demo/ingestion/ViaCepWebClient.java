package com.example.demo.ingestion;

import com.example.demo.model.ViaCep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@AllArgsConstructor
public class ViaCepWebClient {

    private final WebClient webClient;

    public ViaCep getViaCep(String cep) {
        return webClient.get()
                .uri(cep + "/json/")
                .retrieve()
                .bodyToMono(ViaCep.class)
                .block();
    }
}
