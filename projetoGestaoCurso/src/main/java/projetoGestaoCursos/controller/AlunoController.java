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

import projetoGestaoCursos.model.Aluno;
import projetoGestaoCursos.repository.AlunoRepository;
import projetoGestaoCursos.repository.InstrutorRepository;

@RestController // Anotação para deixar endpoint de @RequestMapping ativo e recebendo requisições
@RequestMapping("/api/alunos") // Anotação para indicar o endpoint para usar os métodos
public class AlunoController {

	@Autowired // Anotação que cria um objeto do repository para usar nos métodos
	private AlunoRepository alunoRepository;
	
	@Autowired
	private InstrutorRepository instrutorRepository;
	
	@GetMapping // Anotação para busca dos objetos em alunoRepository
	public List<Aluno> listarAlunos(){
		return alunoRepository.findAll(); 
	}
	
	@PostMapping // Anotação que salva/cria novo objeto Aluno
	public Aluno salvarAluno(@RequestBody Aluno aluno) {
		
		String cpf = aluno.getCpf();
		
		if(instrutorRepository.existsByCpf(cpf) || alunoRepository.existsByCpf(cpf)) { 
			// Verificar se cpf digitado já existe em aluno ou instrutor
			
			throw new RuntimeException("Esse CPF já existe!");
		}
		
		return alunoRepository.save(aluno);
	}
	
	@DeleteMapping("/{id}") // Anotação para Deletar um objeto através de um Id
	public void deletarAluno(@PathVariable Long id) {
		alunoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}") // Anotação para Atualizar um objeto Aluno existente
	public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno novoAluno) {
		
		Optional<Aluno> optionalAluno = alunoRepository.findById(id);
		
		if(optionalAluno.isPresent()) {
			
			Aluno aluno = optionalAluno.get();
			
			aluno.setNome(novoAluno.getNome());
			aluno.setIdade(novoAluno.getIdade());
			aluno.setCpf(novoAluno.getCpf());
			
			String cpf = novoAluno.getCpf();
			
			if(instrutorRepository.existsByCpf(cpf)) { 
				// Verificar se cpf digitado já existe em instrutor
				
				throw new RuntimeException("Esse CPF já existe em Instrutor!");
			}
			if(alunoRepository.existsByCpf(cpf)) {
				// Verifica se cpf já existe em aluno
				
				if(!optionalAluno.get().getId().equals(id)) {
					// Verifica se o cpf é de um aluno diferente o qual deve atualizar
					
					throw new RuntimeException("Esse CPF já existe em Aluno!");
				}
			}
			
			return alunoRepository.save(aluno);
		}
		return null;
	}
}