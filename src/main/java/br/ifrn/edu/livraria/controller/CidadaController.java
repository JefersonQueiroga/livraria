package br.ifrn.edu.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.ifrn.edu.livraria.model.Cidade;
import br.ifrn.edu.livraria.repository.Estados;
import br.ifrn.edu.livraria.service.CidadeService;



@Controller
@RequestMapping("/cidade")
public class CidadaController {
	
	@Autowired
	private CidadeService service;
	
	@Autowired
	private Estados estados;
	
	@RequestMapping("/nova")
	public ModelAndView nova() {
		ModelAndView mv = new ModelAndView("cidade/form");
		mv.addObject("estados", estados.findAll());		
		return mv;
	}
	
	
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Cidade> pesquisarPorCodigoEstado(
			@RequestParam(name = "estado", defaultValue = "-1") Long codigoEstado) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {	}
		return service.findByEstadoCodigo(codigoEstado);
	}
}
