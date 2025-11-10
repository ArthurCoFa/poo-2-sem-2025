package exemplo;

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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
	
	@Autowired
	PessoaRepository pessoaRepository;

	@GetMapping
	public List<Pessoa> listarPessoas(){
		return pessoaRepository.findAll();
	}
	
	@PostMapping
	public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	@DeleteMapping("/{id}")
	public void deletarPessoa(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Pessoa atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa novaPessoa) {
		Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
	    if (optionalPessoa.isPresent()) {
	    	Pessoa pessoa = optionalPessoa.get();
	        pessoa.setNome(novaPessoa.getNome());
	        pessoa.setIdade(novaPessoa.getIdade());
	           
	        return pessoaRepository.save(pessoa);
	   }
	   return null;
	}
	
	@GetMapping("/{id}") // Mapeia para GET /api/alunos/{id}
	public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
	    // Sua lógica de buscar no banco
	    Optional<Pessoa> pessoa = pessoaRepository.findById(id); 

	    // O Spring Boot espera uma resposta correta: 200 OK ou 404 Not Found
	    if (pessoa.isPresent()) {
	        return ResponseEntity.ok(pessoa.get()); // Retorna 200 OK com o JSON do aluno
	    } else {
	        return ResponseEntity.notFound().build(); // Retorna 404 Not Found
	    }
	}

}
