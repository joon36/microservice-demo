package com.example.hello;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class HelloService {

    private WebClient.Builder webClientBuilder;

    public HelloService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public String getWorld() {
        return webClientBuilder.build()
            .get().uri("lb://world")
            .retrieve().bodyToMono(String.class)
            .block();
    }
}
