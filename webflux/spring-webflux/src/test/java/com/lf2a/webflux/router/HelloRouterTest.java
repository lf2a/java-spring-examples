package com.lf2a.webflux.router;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * <h1>HelloRouterTest.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 09/02/2021
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRouterTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testHello() {
        webTestClient
                .get().uri("/hello")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello World");
    }
}
