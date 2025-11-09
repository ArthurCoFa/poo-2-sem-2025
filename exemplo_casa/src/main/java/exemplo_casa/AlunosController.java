package exemplo_casa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/alunos")
public class AlunosController {
	
	@Autowired
	AlunosRepository alunosRepository;
	
	@GetMapping
	public List<Alunos> listarAlunos(){
		return alunosRepository.findAll();
	}
	
	@GetMapping("/{id}") // Mapeia para GET /api/alunos/{id}
	public ResponseEntity<Alunos> getAlunoById(@PathVariable Long id) {
	    // Sua lógica de buscar no banco
	    Optional<Alunos> aluno = alunosRepository.findById(id); 

	    // O Spring Boot espera uma resposta correta: 200 OK ou 404 Not Found
	    if (aluno.isPresent()) {
	        return ResponseEntity.ok(aluno.get()); // Retorna 200 OK com o JSON do aluno
	    } else {
	        return ResponseEntity.notFound().build(); // Retorna 404 Not Found
	    }
	}
	
	@PostMapping
	public Alunos salvarAlunos(@Valid @RequestBody Alunos aluno) {
		
		String novaMatricula = "M-" + String.valueOf(System.currentTimeMillis());
		
		aluno.setMatricula(novaMatricula);
		
		return alunosRepository.save(aluno);
	}
	
	@DeleteMapping("/{id}")
	public void deletarAlunos(@PathVariable Long id) {
		alunosRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Alunos atualizarAlunos(@PathVariable Long id, @Valid @RequestBody Alunos novoAlunos) {
		Optional<Alunos> optionalAlunos = alunosRepository.findById(id);
	    if (optionalAlunos.isPresent()) {
	    		Alunos alunos = optionalAlunos.get();
	        alunos.setNome(novoAlunos.getNome());
	        alunos.setIdade(novoAlunos.getIdade());
	           
	        return alunosRepository.save(alunos);
	   }
	   return null;
	}
}
