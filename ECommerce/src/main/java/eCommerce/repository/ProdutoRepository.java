package eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eCommerce.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
