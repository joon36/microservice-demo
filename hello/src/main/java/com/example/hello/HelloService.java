package com.example.hello;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class HelloService {

    private WebClient.Builder webClientBuilder;

    public HelloService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @CircuitBreaker(name = "backendA", fallbackMethod = "getSlow")
    public String getWorld() {
        return webClientBuilder.build()
            .get().uri("lb://world")
            .retrieve().bodyToMono(String.class)
            .block();
    }

    public String getSlow(Throwable t) {
        return "Slow :(";
    }
}
