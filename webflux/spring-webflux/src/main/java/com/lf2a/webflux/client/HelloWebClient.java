package com.lf2a.webflux.client;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * <h1>HelloWebClient.java</h1>
 * WebClient é non-blocking.
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 09/02/2021
 */
public class HelloWebClient {

    private final WebClient webClient = WebClient.create("http://localhost:8000");

    private final Mono<String> result = webClient.get()
            .uri("/hello")
            .accept(MediaType.TEXT_PLAIN)
            .retrieve().bodyToMono(String.class);

    public String getResult() {
        return ">> result = " + result.block();
    }
}
