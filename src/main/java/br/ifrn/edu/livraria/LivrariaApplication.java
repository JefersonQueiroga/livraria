
package br.ifrn.edu.livraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication	
@EnableScheduling
public class LivrariaApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}
	
	
	
	
}


