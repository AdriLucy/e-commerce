package eCommerce.controller;

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

import eCommerce.model.Cliente;
import eCommerce.repository.ClienteRepository;
import eCommerce.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Cliente> post (@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cliente));
		
	}
	
	// Get all clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteService.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    // Get a cliente by ID
    @GetMapping("/{idCliente}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable long idCliente) {
        Cliente cliente = clienteService.getClienteById(idCliente);
        return ResponseEntity.ok(cliente);
    }

    // Update a cliente by ID
    @PutMapping("/{idCliente}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable long idCliente, @RequestBody Cliente clienteDetails) {
        Cliente updatedCliente = clienteService.updateCliente(idCliente, clienteDetails);
        return ResponseEntity.ok(updatedCliente);
    }

    // Delete a cliente by ID
    @DeleteMapping("/{idCliente}")
    public ResponseEntity<Void> deleteCliente(@PathVariable long idCliente) {
        clienteService.deleteCliente(idCliente);
        return ResponseEntity.noContent().build();
    }

}
