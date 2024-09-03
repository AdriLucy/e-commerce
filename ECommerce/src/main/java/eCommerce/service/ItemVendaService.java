package eCommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eCommerce.Exception.ResourceNotFoundException;
import eCommerce.model.ItemVenda;
import eCommerce.model.Produto;
import eCommerce.repository.ItemVendaRepository;
import eCommerce.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public ItemVenda createItemVenda(ItemVenda itemVenda, long idProduto) {
        // Buscar o produto pelo ID
        Optional<Produto> produtoOpt = produtoRepository.findById(idProduto);
        if (!produtoOpt.isPresent()) {
            throw new RuntimeException("Produto não encontrado com ID: " + idProduto);
        }
        Produto produto = produtoOpt.get();

        // Associar o produto existente ao item de venda
        itemVenda.setProduto(produto);

        // Salvar o item de venda no banco de dados
        return itemVendaRepository.save(itemVenda);
        
        
    }
    

    @Transactional(readOnly = true)
    public ItemVenda getItemVenda(long id) {
        return itemVendaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Item de venda não encontrado com ID: " + id));
    }

    

    public List<ItemVenda> getAllItemVendas() {
        return itemVendaRepository.findAll();
    }

    public ItemVenda getItemVendaById(long idItemVenda) {
        return itemVendaRepository.findById(idItemVenda)
                .orElseThrow(() -> new ResourceNotFoundException("ItemVenda not found with id " + idItemVenda));
    }

    @Transactional
    public ItemVenda updateItemVenda(long idItemVenda, ItemVenda itemVendaDetails) {
        ItemVenda itemVenda = getItemVendaById(idItemVenda);
        // Implemente aqui a lógica para atualizar os campos do itemVenda com base nos detalhes fornecidos
        return itemVendaRepository.save(itemVenda);
    }

    @Transactional
    public void deleteItemVenda(long idItemVenda) {
        ItemVenda itemVenda = getItemVendaById(idItemVenda);
        itemVendaRepository.delete(itemVenda);
    }
}
