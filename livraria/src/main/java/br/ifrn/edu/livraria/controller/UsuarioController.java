package br.ifrn.edu.livraria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ifrn.edu.livraria.model.Categoria;
import br.ifrn.edu.livraria.model.User;
import br.ifrn.edu.livraria.service.UserService;

/**
 * Classe Controle responsável pelo crud dos usuários do Spring Security
 * 
 * @author jeferson
 *
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UserService userService;

	@RequestMapping("/novo")
	public ModelAndView add(User user) {
		ModelAndView mv = new ModelAndView("user/form");
		mv.addObject("user", user);
		return mv;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			return add(user);
		}

		userService.salvar(user);
		ModelAndView rec = findAll();
		return rec;
	}

	@GetMapping("/lista")
	private ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("usuario/lista");
		mv.addObject("usuarios", userService.findAll());
		return mv;
	}

	@GetMapping("/edit/{id}")
	private ModelAndView edit(@PathVariable("id") Long id) {
		User user = (User) userService.findByID(id);
		return add(user);
	}

	@GetMapping("/delete/{id}")
	private ModelAndView delete(@PathVariable("id") Long id) {
		userService.delete(id);
		return findAll();
	}
	
    
   

}
