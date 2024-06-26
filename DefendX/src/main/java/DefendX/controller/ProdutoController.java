package DefendX.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.model.Produto;
import ecommerce.repository.ProdutoRepository;
import ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ProdutoController {
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<Produto> post (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
		
	}
	
	// Get all produtos
    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        List<Produto> produtos = produtoService.getAllProdutos();
        return ResponseEntity.ok(produtos);
    }

    // Get a produto by ID
    @GetMapping("/{idProduto}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable long idProduto) {
        Produto produto = produtoService.getProdutoById(idProduto);
        return ResponseEntity.ok(produto);
    }

    // Update a produto by ID
    @PutMapping("/{idProduto}")
    public ResponseEntity<Produto> updateProduto(@PathVariable long idProduto, @RequestBody Produto produtoDetails) {
        Produto updatedProduto = produtoService.updateProduto(idProduto, produtoDetails);
        return ResponseEntity.ok(updatedProduto);
    }

    // Delete a produto by ID
    @DeleteMapping("/{idProduto}")
    public ResponseEntity<Void> deleteProduto(@PathVariable long idProduto) {
        produtoService.deleteProduto(idProduto);
        return ResponseEntity.noContent().build();
    }

}
