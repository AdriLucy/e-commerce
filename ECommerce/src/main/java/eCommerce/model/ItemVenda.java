package eCommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="item_venda")
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idItemVenda;

    @ManyToOne
    @JoinColumn(name = "idProduto")
    @JsonIgnoreProperties("item_venda")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    @JsonIgnoreProperties("itensVenda")
    private Venda venda;

    private int quantidadeProduto;

    // Getters and Setters
    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public long getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(long idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
}
