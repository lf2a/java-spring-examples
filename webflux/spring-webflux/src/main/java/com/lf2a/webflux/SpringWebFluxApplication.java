package com.lf2a.webflux;

import com.lf2a.webflux.client.HelloWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebFluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebFluxApplication.class, args);

		HelloWebClient webClient = new HelloWebClient();
		System.out.println(webClient.getResult());
	}

}
