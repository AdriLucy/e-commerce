package DefendX.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ecommerce.Exception.ResourceNotFoundException;
import ecommerce.model.Cliente;
import ecommerce.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public Cliente findById(long idCliente) {
        return clienteRepository.findById(idCliente)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
    

    public Cliente getClienteById(long idCliente) {
        return clienteRepository.findById(idCliente)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente not found with id " + idCliente));
    }
    
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente updateCliente(long idCliente, Cliente clienteDetails) {
        Cliente cliente = getClienteById(idCliente);
        cliente.setNome(clienteDetails.getNome());
        cliente.setSobrenome(clienteDetails.getSobrenome());
        cliente.setCpf(clienteDetails.getCpf());
        cliente.setDataNascimento(clienteDetails.getDataNascimento());
        cliente.setTelefone(clienteDetails.getTelefone());
        cliente.setEmail(clienteDetails.getEmail());
        cliente.setCep(clienteDetails.getCep());
        cliente.setEndereco(clienteDetails.getEndereco());
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void deleteCliente(long idCliente) {
        Cliente cliente = getClienteById(idCliente);
        clienteRepository.delete(cliente);
    }
}
