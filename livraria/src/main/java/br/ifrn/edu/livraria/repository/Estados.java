package br.ifrn.edu.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifrn.edu.livraria.model.Estado;

public interface Estados extends JpaRepository<Estado, Long> {

}
