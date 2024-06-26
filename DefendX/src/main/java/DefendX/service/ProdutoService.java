package DefendX.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.Exception.ResourceNotFoundException;
import ecommerce.model.Produto;
import ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public Produto findById(long idProduto) {
        return produtoRepository.findById(idProduto)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
    
    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Produto getProdutoById(long idProduto) {
        return produtoRepository.findById(idProduto)
                .orElseThrow(() -> new ResourceNotFoundException("Produto not found with id " + idProduto));
    }

    @Transactional
    public Produto updateProduto(long idProduto, Produto produtoDetails) {
        Produto produto = getProdutoById(idProduto);
        produto.setNome(produtoDetails.getNome());
        produto.setPreco(produtoDetails.getPreco());
        produto.setQuantidadeEstoque(produtoDetails.getQuantidadeEstoque());
        produto.setDescricao(produtoDetails.getDescricao());
        return produtoRepository.save(produto);
    }

    @Transactional
    public void deleteProduto(long idProduto) {
        Produto produto = getProdutoById(idProduto);
        produtoRepository.delete(produto);
    }
}
