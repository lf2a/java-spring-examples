package com.github.lf2a.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <h1>AppConfig.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 29/03/2021
 */
@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTamplate() {
        return new RestTemplate();
    }
}
