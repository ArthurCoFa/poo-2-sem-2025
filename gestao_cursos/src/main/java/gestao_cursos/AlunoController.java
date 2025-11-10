package gestao_cursos;

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

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@PostMapping
	public Aluno salvarAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@GetMapping
	public List<Aluno> listarAlunos() {	
		return alunoRepository.findAll();
	}
	
	@GetMapping("/{id}") // Mapeia para GET /api/alunos/{id}
	public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
	    // Sua lógica de buscar no banco
	    Optional<Aluno> aluno = alunoRepository.findById(id); 

	    // O Spring Boot espera uma resposta correta: 200 OK ou 404 Not Found
	    if (aluno.isPresent()) {
	        return ResponseEntity.ok(aluno.get()); // Retorna 200 OK com o JSON do aluno
	    } else {
	        return ResponseEntity.notFound().build(); // Retorna 404 Not Found
	    }
	}
	
	@DeleteMapping("/{id}")
	public void deletarAlunos(@PathVariable Long id) {
		alunoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Aluno atualizarAlunos(@PathVariable Long id, @RequestBody Aluno novoAluno) {
		Optional<Aluno> optionalAluno = alunoRepository.findById(id);
		if(optionalAluno.isPresent()) {
			Aluno aluno = optionalAluno.get();
	        aluno.setNomeAluno(novoAluno.getNomeAluno());
	        aluno.setIdade(novoAluno.getIdade());
	           
	        return alunoRepository.save(aluno);
		}
		return null;
	}
}
