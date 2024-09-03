package eCommerce.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVenda;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("venda")
    private List<ItemVenda> itensVenda;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    @JsonIgnoreProperties("venda")
    private Cliente cliente;

    private double precoTotalVenda;

    private String data;

    // Getters and Setters
    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPrecoTotalVenda() {
        return precoTotalVenda;
    }

    public void setPrecoTotalVenda(double precoTotalVenda) {
        this.precoTotalVenda = precoTotalVenda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
