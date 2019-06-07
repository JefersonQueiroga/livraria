package br.ifrn.edu.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.ifrn.edu.livraria.model.Autor;
import br.ifrn.edu.livraria.repository.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	private AutorRepository repository;
	
	@Cacheable(value="cacheAutor")
	public List<Autor> listaAll(){
		System.out.println("Testando Cache...................");
		return repository.findAll();
	}
	
	public void cadastrar(Autor a) {
		repository.saveAndFlush(a);
	}
	
	public Autor  findOne(Long id) {
        return repository.getOne(id);
    }
    
	@CacheEvict(value="cacheAutor")
    public Autor save(Autor a) {
        return repository.saveAndFlush(a);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
