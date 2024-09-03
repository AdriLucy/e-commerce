package eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eCommerce.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	

}
