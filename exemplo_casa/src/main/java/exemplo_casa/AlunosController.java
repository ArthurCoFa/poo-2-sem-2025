package exemplo_casa;

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
public class AlunosController {
	
	@Autowired
	AlunosRepository alunosRepository;
	
	@GetMapping
	public List<Alunos> listarAlunos(){
		return alunosRepository.findAll();
	}
	
	@PostMapping
	public Alunos salvarAlunos(@RequestBody Alunos aluno) {
		return alunosRepository.save(aluno);
	}
	
	@DeleteMapping("/{id}")
	public void deletarAlunos(@PathVariable Long id) {
		alunosRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Alunos atualizarAlunos(@PathVariable Long id, @RequestBody Alunos novoAlunos) {
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
