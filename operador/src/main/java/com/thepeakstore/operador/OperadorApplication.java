package com.thepeakstore.operador;

import com.thepeakstore.operador.service.ProductoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.thepeakstore.operador.repository")
@EnableElasticsearchRepositories(basePackages = "com.thepeakstore.operador.repository.elastic")
public class OperadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OperadorApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProductoService service) {
		return args -> {
			service.syncToElastic();
		};
	}
}
