package gestao_cursos;

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

@RestController
@RequestMapping("/api/instrutor")
public class InstrutorController {

	@Autowired
	private InstrutorRepository instrutorRepository;
	
	@GetMapping("/{id}")
	public Optional<Instrutor> listarInstrutorId(@PathVariable Long id) {
		Optional<Instrutor> optionalInstrutor = instrutorRepository.findById(id);
		
		if(optionalInstrutor.isPresent()) return optionalInstrutor;
		
		return null;
	}
	
	@GetMapping
	public List<Instrutor> listarInstrutores() {
		
		return instrutorRepository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void deletarInstrutor(@PathVariable Long id) {
		instrutorRepository.deleteById(id);
	}
	
	@PostMapping
	public Instrutor salvarInstrutor(@RequestBody Instrutor instrutor) {
		
		return instrutorRepository.save(instrutor);
	}
	
	@PutMapping("/{id}")
	public Instrutor atualizarInstrutor(@PathVariable Long id, @RequestBody Instrutor novoInstrutor) {
		
		Optional<Instrutor> optionalInstrutor = instrutorRepository.findById(id);
		
		if(optionalInstrutor.isPresent()) {
			
			Instrutor instrutor = optionalInstrutor.get();
			
			instrutor.setNomeInstrutor(novoInstrutor.getNomeInstrutor());
			instrutor.setIdade(novoInstrutor.getIdade());
			
			return instrutorRepository.save(instrutor);
		}
		return null;
	}
}
