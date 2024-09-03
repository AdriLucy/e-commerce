package eCommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import eCommerce.model.ItemVenda;
import eCommerce.service.ItemVendaService;

@RestController
@RequestMapping("/itensvenda")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;

    @PostMapping
    public ResponseEntity<ItemVenda> createItemVenda(@RequestBody ItemVenda itemVenda, @RequestParam long produtoId) {
        ItemVenda novoItemVenda = itemVendaService.createItemVenda(itemVenda, produtoId);
        return ResponseEntity.ok(novoItemVenda);
    }


 // Get all itemVendas
   
    // Get an itemVenda by ID
    @GetMapping("/{idItemVenda}")
    public ResponseEntity<ItemVenda> getItemVendaById(@PathVariable long idItemVenda) {
        ItemVenda itemVenda = itemVendaService.getItemVendaById(idItemVenda);
        return ResponseEntity.ok(itemVenda);
    }

    // Update an itemVenda by ID
    @PutMapping("/{idItemVenda}")
    public ResponseEntity<ItemVenda> updateItemVenda(@PathVariable long idItemVenda, @RequestBody ItemVenda itemVendaDetails) {
        ItemVenda updatedItemVenda = itemVendaService.updateItemVenda(idItemVenda, itemVendaDetails);
        return ResponseEntity.ok(updatedItemVenda);
    }

    // Delete an itemVenda by ID
    @DeleteMapping("/{idItemVenda}")
    public ResponseEntity<Void> deleteItemVenda(@PathVariable long idItemVenda) {
        itemVendaService.deleteItemVenda(idItemVenda);
        return ResponseEntity.noContent().build();
    }
}
