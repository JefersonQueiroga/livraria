package br.ifrn.edu.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifrn.edu.livraria.model.User;



@Repository
public interface UserRepository  extends JpaRepository<User,Long>{

	User findByUsername(String username);
	
}
