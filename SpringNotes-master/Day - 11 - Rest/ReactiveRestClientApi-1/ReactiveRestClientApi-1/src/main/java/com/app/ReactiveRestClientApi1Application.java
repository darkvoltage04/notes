package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ReactiveRestClientApi1Application {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveRestClientApi1Application.class, args);
	}

	
	@Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl("http://localhost:2025/emp").build();
    }
}
