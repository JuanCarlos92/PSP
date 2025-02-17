package org.example.microservicio_api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicioApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioApiGatewayApplication.class, args);
    }

}
