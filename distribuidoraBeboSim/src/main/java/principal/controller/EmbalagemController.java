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

import principal.classes.Embalagem;
import principal.respository.EmbalagemRepository;

@RestController
@RequestMapping("/api/embalagem")
public class EmbalagemController {

	@Autowired
	private EmbalagemRepository embalagemRepository;
	
	@GetMapping
	public List<Embalagem> listarEmbalagens(){
		return embalagemRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Embalagem> buscarEmbalagemId(@PathVariable Long id) {
		Optional<Embalagem> optionalEmbalagem = embalagemRepository.findById(id);
		
		if(optionalEmbalagem.isPresent()) return optionalEmbalagem;
		
		return null;
	}
	
	@PostMapping
	public Embalagem salvarEmbalagem(@RequestBody Embalagem embalagem) {
		return embalagemRepository.save(embalagem);
	}
	
	@PutMapping("/{id}")
	public Embalagem atualizarEmbalagem(@PathVariable Long id, @RequestBody Embalagem novaEmbalagem) {
		
		Optional<Embalagem> optionalEmbalagem = embalagemRepository.findById(id);
		
		if(optionalEmbalagem.isPresent()) {
			Embalagem embalagem = optionalEmbalagem.get();
			embalagem.setCusto(novaEmbalagem.getCusto());
			embalagem.setMaterial(novaEmbalagem.getMaterial());
			embalagem.setTamanho(novaEmbalagem.getTamanho());
			
			return embalagemRepository.save(embalagem);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deletarEmbalagem(@PathVariable Long id) {
		embalagemRepository.deleteById(id);
	}
}
