package DefendX.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
