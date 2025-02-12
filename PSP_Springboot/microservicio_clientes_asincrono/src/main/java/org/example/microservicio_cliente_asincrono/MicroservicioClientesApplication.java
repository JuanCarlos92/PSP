package org.example.microservicio_cliente_asincrono;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

@EnableAsync
@SpringBootApplication
public class MicroservicioClientesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioClientesApplication.class, args);
    }

    @Bean
    public RestTemplate template() {
        return new RestTemplate();
    }

    @Bean
    public Executor executor(){
        return new ThreadPoolTaskExecutor();
    }

}
