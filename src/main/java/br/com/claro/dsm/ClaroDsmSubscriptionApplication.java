package br.com.claro.dsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ClaroDsmSubscriptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaroDsmSubscriptionApplication.class, args);
	}

}
