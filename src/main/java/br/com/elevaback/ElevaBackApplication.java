package br.com.elevaback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ElevaBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElevaBackApplication.class, args);
	}
}
