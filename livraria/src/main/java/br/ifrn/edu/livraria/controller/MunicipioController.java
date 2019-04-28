package br.ifrn.edu.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.ifrn.edu.livraria.client.MunicipioClient;
import br.ifrn.edu.livraria.dto.Municipio;
import br.ifrn.edu.livraria.dto.Regiao;

@Controller
public class MunicipioController {
	
	@Autowired
	private MunicipioClient municipio;
	
	@GetMapping("/regiao")
	public String entrar() {
	List<Regiao> regioes = municipio.buscarRegioes();
		
		for(Regiao r : regioes ) {
			System.out.println(r.getNome());
		}
		
		return "index";
	}
	
	
	@GetMapping("/municipio")
	public String listaMunicipio() {
	List<Municipio> regioes = municipio.buscarMunicipioByUF(33);
		
		for(Municipio r : regioes ) {
			System.out.println(r.getNome());
		}
		
		return "index";
	}
	
}
