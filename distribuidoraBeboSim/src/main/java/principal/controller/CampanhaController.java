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

import principal.classes.Campanha;
import principal.respository.CampanhaRepository;

@RestController
@RequestMapping("/api/campanha")
public class CampanhaController {

	@Autowired
	private CampanhaRepository campanhaRepository;
	
	@GetMapping
	public List<Campanha> listarCampanhas(){
		return campanhaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Campanha> buscarCampanhaId(@PathVariable Long id) {
		
		Optional<Campanha> optionalCampanha = campanhaRepository.findById(id);
		
		if(optionalCampanha.isPresent()) return optionalCampanha;
		
		return null;
	}
	
	@PostMapping
	public Campanha salvarCampanha(@RequestBody Campanha campanha) {
		return campanhaRepository.save(campanha);
	}
	
	@PutMapping("/{id}")
	public Campanha atualizarCampanha(@PathVariable Long id, @RequestBody Campanha novaCampanha) {
		
		Optional<Campanha> optionalCampanha = campanhaRepository.findById(id);
		
		if(optionalCampanha.isPresent()) {
			
			Campanha campanha = optionalCampanha.get();
			campanha.setDtFim(novaCampanha.getDtFim());
			campanha.setDtInicio(novaCampanha.getDtInicio());
			campanha.setNome(novaCampanha.getNome());
			
			return campanhaRepository.save(campanha);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deletarCampanha(@PathVariable Long id) {
		campanhaRepository.deleteById(id);
	}
}
