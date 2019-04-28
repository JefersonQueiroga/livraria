package br.ifrn.edu.livraria;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.ifrn.edu.livraria.client.MunicipioClient;

@SpringBootApplication
public class LivrariaApplication {

		
	
	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}
	
	
}


