package projetoGestaoCursos.controller;
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

import projetoGestaoCursos.model.Instrutor;
import projetoGestaoCursos.repository.AlunoRepository;
import projetoGestaoCursos.repository.InstrutorRepository;

@RestController // Anotação para deixar endpoint de @RequestMapping ativo e recebendo requisições
@RequestMapping("/api/instrutores") // Anotação para indicar o endpoint para usar os métodos
public class InstrutorController {

	@Autowired // Anotação que cria um objeto do repository para usar nos métodos
	private InstrutorRepository instrutorRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping // Anotação para busca dos objetos em instrutorRepository
	public List<Instrutor> listarInstrutores() {
		return instrutorRepository.findAll();
	}
	
	@PostMapping // Anotação que salva/cria novo objeto Instrutor
	public Instrutor salvarInstrutor(@RequestBody Instrutor instrutor) {
		
		String cpf = instrutor.getCpf();
		
		if(instrutorRepository.existsByCpf(cpf) || alunoRepository.existsByCpf(cpf)) { 
			// Verificar se cpf digitado já existe em aluno ou instrutor
			
			throw new RuntimeException("Esse CPF já existe!");
		}
		
		return instrutorRepository.save(instrutor);
	}
	
	@DeleteMapping("/{id}") // Anotação para Deletar um objeto através de um Id, caso não esteja em um curso
	public void deletarInstrutor(@PathVariable Long id) {			
		instrutorRepository.deleteById(id);		
	}
	
	@PutMapping("/{id}")// Anotação para Atualizar um objeto Instrutor
	public Instrutor atualizarInstrutor(@PathVariable Long id, @RequestBody Instrutor novoInstrutor) {
		
		Optional<Instrutor> optionalInstrutor = instrutorRepository.findById(id);
		
		if(optionalInstrutor.isPresent()) {
			
			Instrutor instrutor = optionalInstrutor.get();
			
			instrutor.setCpf(novoInstrutor.getCpf());
			instrutor.setNome(novoInstrutor.getNome());
			instrutor.setIdade(novoInstrutor.getIdade());
			
			String cpf = novoInstrutor.getCpf();
			
			if(alunoRepository.existsByCpf(cpf)) { 
				// Verificar se cpf digitado já existe em aluno
				
				throw new RuntimeException("Esse CPF já existe em Aluno!");
			}
			if(instrutorRepository.existsByCpf(cpf)) {
				// Verificar se cpf já existe em instrutor
				
				if(!optionalInstrutor.get().getId().equals(id)) {
					// Verifica se o cpf é de um aluno diferente o qual deve atualizar
					
					throw new RuntimeException("Esse CPF já existe em Instrutor!");
				}
			}
			
			return instrutorRepository.save(instrutor);
		}
		return null;
	}
}
