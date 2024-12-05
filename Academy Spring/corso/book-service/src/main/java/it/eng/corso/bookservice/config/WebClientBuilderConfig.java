package it.eng.corso.bookservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientBuilderConfig {

    //permette di richiamare un microservizio da un altro microservizio
    @Bean
    @LoadBalanced //stiamo chiedendo a Spring di
    public WebClient.Builder webClientBuilder(){

        return WebClient.builder();
    }
}
