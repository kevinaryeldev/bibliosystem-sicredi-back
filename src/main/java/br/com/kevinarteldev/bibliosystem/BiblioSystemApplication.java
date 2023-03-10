package br.com.kevinarteldev.bibliosystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BiblioSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(BiblioSystemApplication.class, args);
	}

}
