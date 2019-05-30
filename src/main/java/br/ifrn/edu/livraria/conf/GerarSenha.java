package br.ifrn.edu.livraria.conf;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GerarSenha {
	 public static void main(String[] args) {    
	        String senhaCriptografado = new BCryptPasswordEncoder().encode("123456");
	        System.out.println(senhaCriptografado);
	    }
	
}
