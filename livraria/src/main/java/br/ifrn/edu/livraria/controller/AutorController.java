package br.ifrn.edu.livraria.controller;

import java.util.Arrays;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ifrn.edu.livraria.model.Autor;
import br.ifrn.edu.livraria.model.Sexo;
import br.ifrn.edu.livraria.service.AutorService;

@Controller
@RequestMapping("/autor")
public class AutorController {
	
	@Autowired
	private AutorService autorService;
			
	
	@RequestMapping("/novo")
	public ModelAndView add(Autor autor) {
		ModelAndView mv = new ModelAndView("autor/form");
		mv.addObject("autor", autor);
		mv.addObject("sexos", Arrays.asList( Sexo.values() ));
		return mv;
	}
		
	@GetMapping("/edit/{id}")
	private ModelAndView edit( @PathVariable("id") Long id) {
		Autor aut = autorService.findOne(id);
		System.out.println(aut.getNome());
		return add(aut);
	}
	
	
	/**
	 * metodo para deletar
	 * Colocado a anotação ROLES_ALLOWED para deletar precisa do papel de administrador.
	 * @param id
	 * @return
	 */
	@RolesAllowed("ADMINISTRADOR")
	@GetMapping("/delete/{id}")
	private ModelAndView delete( @PathVariable("id") Long id) {
		autorService.delete(id);
		return findAll();
	}


	
	@PostMapping("/save")
    public ModelAndView save(@Valid Autor aut, BindingResult result) {
		 
		if(result.hasErrors()) {
			return add(aut);
	    }

		autorService.cadastrar(aut);
		
		ModelAndView rec =findAll();
		rec.addObject("mensagem", "Autor salvo com sucesso!");
		
		return rec;
    }

	@GetMapping("/lista")
	private ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("autor/lista");
        mv.addObject("autores", autorService.listaAll());
        return mv;
	}
}
