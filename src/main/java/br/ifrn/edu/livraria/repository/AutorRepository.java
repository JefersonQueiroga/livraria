package br.ifrn.edu.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifrn.edu.livraria.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
