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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.model.Venda;
import ecommerce.repository.VendaRepository;
import ecommerce.service.VendaService;

@RestController
@RequestMapping("/venda")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class VendaController {
	
	
	@Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> createVenda(@RequestBody Venda venda) {
        Venda novaVenda = vendaService.createVenda(venda);
        return ResponseEntity.ok(novaVenda);
    }
    
    // Get all vendas
    @GetMapping
    public ResponseEntity<List<Venda>> getAllVendas() {
        List<Venda> vendas = vendaService.getAllVendas();
        return ResponseEntity.ok(vendas);
    }

    // Get a venda by ID
    @GetMapping("/{idVenda}")
    public ResponseEntity<Venda> getVendaById(@PathVariable long idVenda) {
        Venda venda = vendaService.getVendaById(idVenda);
        return ResponseEntity.ok(venda);
    }

    // Update a venda by ID
    @PutMapping("/{idVenda}")
    public ResponseEntity<Venda> updateVenda(@PathVariable long idVenda, @RequestBody Venda vendaDetails) {
        Venda updatedVenda = vendaService.updateVenda(idVenda, vendaDetails);
        return ResponseEntity.ok(updatedVenda);
    }

    // Delete a venda by ID
    @DeleteMapping("/{idVenda}")
    public ResponseEntity<Void> deleteVenda(@PathVariable long idVenda) {
        vendaService.deleteVenda(idVenda);
        return ResponseEntity.noContent().build();
    }
    

}
