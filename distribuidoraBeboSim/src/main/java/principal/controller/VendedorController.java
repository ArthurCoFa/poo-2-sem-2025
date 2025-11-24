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

import principal.classes.Vendedor;
import principal.respository.VendedorRepository;

@RestController
@RequestMapping("/api/vendedor")
public class VendedorController {

	// unique
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@GetMapping
	public List<Vendedor> listarVendedores(){
		return vendedorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Vendedor> buscarVendedorId(@PathVariable Long id){
		Optional<Vendedor> optionalVendedor = vendedorRepository.findById(id);
		
		if(optionalVendedor.isPresent()) return optionalVendedor;
		
		return null;
	}
	
	@PostMapping
	public Vendedor salvarVendedor(@RequestBody Vendedor vendedor) {
		return vendedorRepository.save(vendedor);
	}
	
	@PutMapping("/{id}")
	public Vendedor atualizarVendedor(@PathVariable Long id, @RequestBody Vendedor novoVendedor) {
		Optional<Vendedor> optionalVendedor = vendedorRepository.findById(id);
		
		if(optionalVendedor.isPresent()) {
			Vendedor vendedor = optionalVendedor.get();
			vendedor.setCpf(novoVendedor.getCpf());
			vendedor.setDtAdmissao(novoVendedor.getDtAdmissao());
			vendedor.setEmail(novoVendedor.getEmail());
			vendedor.setEndereco(novoVendedor.getEndereco());
			vendedor.setNome(novoVendedor.getNome());
			vendedor.setNrCarteiraTrabalho(novoVendedor.getNrCarteiraTrabalho());
			vendedor.setTelefone(novoVendedor.getTelefone());
			
			return vendedorRepository.save(vendedor);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deletarVendedor(@PathVariable Long id) {
		vendedorRepository.deleteById(id);
	}
}
