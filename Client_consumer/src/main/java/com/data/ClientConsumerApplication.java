package com.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientConsumerApplication.class, args);
	}
	@Bean
	public RestTemplate rt() {
		RestTemplate rs = new RestTemplate();
		return rs;
	}
}
