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

import principal.classes.Fabrica;
import principal.respository.FabricaRepository;

@RestController
@RequestMapping("/api/fabrica")
public class FabricaController {
	
	// unique

	@Autowired
	private FabricaRepository fabricaRepository;
	
	@GetMapping
	public List<Fabrica> listarFabricas(){
		return fabricaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Fabrica> buscarFabricaId(@PathVariable Long id){
		Optional<Fabrica> optionalFabrica = fabricaRepository.findById(id);
		
		if(optionalFabrica.isPresent()) return optionalFabrica;
		
		return null;
	}
	
	@PostMapping
	public Fabrica salvarFabrica(@RequestBody Fabrica fabrica) {
		return fabricaRepository.save(fabrica);
	}
	
	@PutMapping("/{id}")
	public Fabrica atualizarFabrica(@PathVariable Long id, @RequestBody Fabrica novaFabrica) {
		Optional<Fabrica> optionaFabrica = fabricaRepository.findById(id);
		
		if(optionaFabrica.isPresent()) {
			Fabrica fabrica = optionaFabrica.get();
			fabrica.setAreaConstrucao(novaFabrica.getAreaConstrucao());
			fabrica.setCnpj(novaFabrica.getCnpj());
			fabrica.setEndereco(novaFabrica.getEndereco());
			fabrica.setNome(novaFabrica.getNome());
			fabrica.setTelefone(novaFabrica.getTelefone());
			
			return fabricaRepository.save(fabrica);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deletarFabrica(@PathVariable Long id) {
		fabricaRepository.deleteById(id);
	}
}
