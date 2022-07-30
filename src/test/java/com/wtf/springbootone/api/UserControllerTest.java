package com.wtf.springbootone.api;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

class UserControllerTest {

    WebClient webClient = WebClient.builder().baseUrl("localhost:8080").build();

    MockMvc mockMvc;

    @Test
    void iWantToTestThis() {
        getFlux()
                .log()
                .map(String::toUpperCase);
    }

    Flux<String> getFlux() {
        return Flux.just("red", "white", "blue");
    }
}
