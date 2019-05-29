package br.ifrn.edu.livraria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifrn.edu.livraria.model.Cidade;
import br.ifrn.edu.livraria.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;

	public List<Cidade> listaAll(){
		return repository.findAll();
	}
	
	public void cadastrar(Cidade c) {
		repository.saveAndFlush(c);
	}
	
	public Cidade  findOne(Long id) {
        return repository.getOne(id);
    }
     
    public Cidade save(Cidade c) {
        return repository.saveAndFlush(c);
    }
     
    public void delete(Long id) {
        repository.deleteById(id);
    }

	public List<Cidade> findByEstadoCodigo(Long codigoEstado) {
		return repository.findByEstadoCodigo(codigoEstado); 
	}
}
