package principal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import principal.classes.Cliente;
import principal.respository.ClienteRepository;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	// Mudar cnpj unique
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listarClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Cliente> buscarClienteId(@PathVariable Long id) {
		Optional<Cliente> optionalCliente = clienteRepository.findById(id);
		
		if(optionalCliente.isPresent()) return optionalCliente;
		
		return null;
	}
	
	@PostMapping
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{id}")
	public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente novoCliente) {
		Optional<Cliente> optionalCliente = clienteRepository.findById(id);
		
		if(optionalCliente.isPresent()) {
			Cliente cliente = optionalCliente.get();
			cliente.setCnpj(novoCliente.getCnpj());
			cliente.setEndereco(novoCliente.getEndereco());
			cliente.setPessoaContato(novoCliente.getPessoaContato());
			cliente.setRazaoSocial(novoCliente.getRazaoSocial());
			cliente.setTelefone(novoCliente.getTelefone());
			
			return clienteRepository.save(cliente);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deletarCliente(@PathVariable Long id) {
		clienteRepository.deleteById(id);
	}
}
