package br.ifrn.edu.livraria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifrn.edu.livraria.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade,Long>{
	public List<Cidade> findByEstadoCodigo(Long codigoEstado);
}
