package DefendX.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	

}
