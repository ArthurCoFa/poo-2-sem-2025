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

import principal.classes.Regiao;
import principal.respository.RegiaoRepository;

@RestController
@RequestMapping("/api/regiao")
public class RegiaoController {

	@Autowired
	private RegiaoRepository regiaoRepository;
	
	@GetMapping
	public List<Regiao> listarRegioes(){
		return regiaoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Regiao> buscarRegiaoId(@PathVariable Long id){
		Optional<Regiao> optionalRegiao = regiaoRepository.findById(id);
		
		if(optionalRegiao.isPresent()) return optionalRegiao;
		
		return null;
	}
	
	@PostMapping
	public Regiao salvarRegiao(@RequestBody Regiao regiao) {
		return regiaoRepository.save(regiao);
	}
	
	@PutMapping("/{id}")
	public Regiao atualizarRegiao(@PathVariable Long id, @RequestBody Regiao novaRegiao) {
		Optional<Regiao> optionalRegiao = regiaoRepository.findById(id);
		
		if(optionalRegiao.isPresent()) {
			Regiao regiao = optionalRegiao.get();
			regiao.setNome(novaRegiao.getNome());
			
			return regiaoRepository.save(regiao);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deletarRegiao(@PathVariable Long id) {
		regiaoRepository.deleteById(id);
	}
}
