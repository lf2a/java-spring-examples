package com.lf2a.webflux.router;

import com.lf2a.webflux.handler.HelloWorldHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * <h1>HelloRouter.java</h1>
 * O router irá ser usado para tratar a rota que irá ser exposta (/hello).
 * O router ouve chamadas para a rota (/hello) e retorna o valor fornecido pela classe reativa Handler.
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 09/02/2021
 */
@Configuration
public class HelloRouter {

    @Bean
    public RouterFunction<ServerResponse> route(HelloWorldHandler helloWorldHandler) {
        return RouterFunctions.route(
                RequestPredicates
                        .GET("/hello")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), helloWorldHandler::hello);
    }
}
