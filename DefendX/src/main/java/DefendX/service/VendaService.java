package DefendX.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.Exception.ResourceNotFoundException;
import ecommerce.model.ItemVenda;
import ecommerce.model.Produto;
import ecommerce.model.Venda;
import ecommerce.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Transactional
    public Venda createVenda(Venda venda) {
        // Obtém o cliente do banco de dados
        venda.setCliente(clienteService.findById(venda.getCliente().getIdCliente()));

        // Calcula o preço total da venda e define os produtos nos itens de venda
        double precoTotal = 0.0;
        for (ItemVenda item : venda.getItensVenda()) {
            Produto produto = produtoService.findById(item.getProduto().getIdProduto());
            item.setProduto(produto); // Necessário para manter a referência correta
            item.setVenda(venda); // Necessário para manter a referência correta
            precoTotal += produto.getPreco() * item.getQuantidadeProduto();
        }
        venda.setPrecoTotalVenda(precoTotal);

        // Persiste a venda no banco de dados
        return vendaRepository.save(venda);
    }
    
    public List<Venda> getAllVendas() {
        return vendaRepository.findAll();
    }

    public Venda getVendaById(long idVenda) {
        return vendaRepository.findById(idVenda)
                .orElseThrow(() -> new ResourceNotFoundException("Venda não encontrada com id " + idVenda));
    }

    @Transactional
    public Venda updateVenda(long idVenda, Venda vendaDetails) {
    	Venda venda = getVendaById(idVenda);
        venda.setCliente(clienteService.findById(vendaDetails.getCliente().getIdCliente()));

        // Calcula o preço total da venda e define os produtos nos itens de venda
        double precoTotal = 0.0;
        for (ItemVenda item : vendaDetails.getItensVenda()) {
            Produto produto = produtoService.findById(item.getProduto().getIdProduto());
            item.setProduto(produto); // Necessário para manter a referência correta
            item.setVenda(venda); // Necessário para manter a referência correta
            precoTotal += produto.getPreco() * item.getQuantidadeProduto();
        }
        venda.setItensVenda(vendaDetails.getItensVenda());
        venda.setPrecoTotalVenda(precoTotal);
        venda.setData(vendaDetails.getData());

        return vendaRepository.save(venda);
    }

    @Transactional
    public void deleteVenda(long idVenda) {
        Venda venda = getVendaById(idVenda);
        vendaRepository.delete(venda);
    }
}
