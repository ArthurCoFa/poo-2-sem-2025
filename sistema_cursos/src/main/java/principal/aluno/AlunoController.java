package principal.aluno;

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
@RequestMapping("/api/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public List<Aluno> listarAlunos(){
		return alunoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Aluno> listarAlunoId(@PathVariable Long id) {
		
		Optional<Aluno> optionalAluno = alunoRepository.findById(id);
		
		if(optionalAluno.isPresent()) {
			return optionalAluno;
		}
		return null;
	}
	
	@PostMapping
	public Aluno salvarAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@DeleteMapping("/{id}")
	public void deletarAluno(@PathVariable Long id) {
		alunoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno novoAluno) {
		
		Optional<Aluno> optionalAluno = alunoRepository.findById(id);
		
		if(optionalAluno.isPresent()) {
			
			Aluno aluno = optionalAluno.get();
			
			aluno.setNome(novoAluno.getNome());
			aluno.setIdade(novoAluno.getIdade());
			
			return alunoRepository.save(aluno);
		}
		return null;
	}
}
