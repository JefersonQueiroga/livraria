package br.ifrn.edu.livraria.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifrn.edu.livraria.model.Autor;
import br.ifrn.edu.livraria.service.AutorService;

@RestController
@RequestMapping("/api/autor")
public class AutorResource {

	@Autowired
	private AutorService autorService;
	
	@GetMapping("/listar")
	public List<Autor> listar() {
		return autorService.listaAll();
	}
	
}
