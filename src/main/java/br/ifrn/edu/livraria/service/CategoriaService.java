package br.ifrn.edu.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.edu.livraria.model.Categoria;
import br.ifrn.edu.livraria.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> listaAll(){
		return repository.findAll();
	}
	
	public void cadastrar(Categoria cat) {
		repository.saveAndFlush(cat);
	}
	
	public Categoria  findOne(Long id) {
        return repository.getOne(id);
    }
     
    public Categoria save(Categoria cat) {
        return repository.saveAndFlush(cat);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }

	
	
}
