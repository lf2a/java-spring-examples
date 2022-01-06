package com.lf2a.webflux.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * <h1>HelloWorldHandler.java</h1>
 * Este handler irá tratar as requisições e criar as respostas.
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 09/02/2021
 */
@Component
public class HelloWorldHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        /**
         * Este método irá sempre retornar "Hello World", mas pode retornar varias outras coisas
         * inclusive um stream de itens do banco de dados
         */
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue("Hello World"));
    }
}
