package principal.instrutor;

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

import jakarta.validation.Valid;
import principal.aluno.AlunoRepository;

@RestController
@RequestMapping("/api/instrutores")
public class InstrutorController {

	@Autowired
	private InstrutorRepository instrutorRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public List<Instrutor> listarInstrutores() {
		return instrutorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Instrutor> listarInstrutorId(@PathVariable Long id) {
		
		Optional<Instrutor> optionalInstrutor = instrutorRepository.findById(id);
		
		if(optionalInstrutor.isPresent()) {
			return optionalInstrutor;
		}
		return null;
	}
	
	@PostMapping
	public Instrutor salvarInstrutor(@RequestBody @Valid Instrutor instrutor) {
		
		String cpf = instrutor.getCpf();
		
		if(instrutorRepository.existsByCpf(cpf)) {
			
			throw new RuntimeException("CPF já existe em Insrutor!");
		}
		
		if(alunoRepository.existsByCpf(cpf)) {
			
			throw new RuntimeException("CPF já existe em Aluno");
		}
		
		return instrutorRepository.save(instrutor);
	}
	
	@DeleteMapping("/{id}")
	public void deletarInstrutor(@PathVariable Long id) {			
		instrutorRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Instrutor atualizarInstrutor(@PathVariable Long id, @RequestBody Instrutor novoInstrutor) {
		
		Optional<Instrutor> optionalInstrutor = instrutorRepository.findById(id);
		
		if(optionalInstrutor.isPresent()) {
			
			Instrutor instrutor = optionalInstrutor.get();
			
			instrutor.setCpf(novoInstrutor.getCpf());
			instrutor.setNome(novoInstrutor.getNome());
			instrutor.setIdade(novoInstrutor.getIdade());
			
			return instrutorRepository.save(instrutor);
		}
		return null;
	}
}
