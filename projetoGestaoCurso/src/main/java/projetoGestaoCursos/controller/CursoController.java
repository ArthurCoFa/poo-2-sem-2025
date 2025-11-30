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

import projetoGestaoCursos.model.Curso;
import projetoGestaoCursos.model.Instrutor;
import projetoGestaoCursos.repository.CursoRepository;
import projetoGestaoCursos.repository.InstrutorRepository;

@RestController // Anotação para deixar endpoint de @RequestMapping ativo e recebendo requisições
@RequestMapping("/api/cursos") // Anotação para indicar o endpoint para usar os métodos
public class CursoController {

	@Autowired // Anotação que cria um objeto do repository para usar nos métodos
	private CursoRepository cursoRepository;
	@Autowired
	private InstrutorRepository instrutorRepository;
	
	@PostMapping("/{idInstrutor}") // Anotação que salva/cria novo objeto Curso, com id do Instrutor
	public Curso adicionarCurso(@PathVariable Long idInstrutor, @RequestBody Curso curso) {
		
		Optional<Instrutor> optionalInstrutor = instrutorRepository.findById(idInstrutor);
		
		if(optionalInstrutor.isPresent()) {
			
			Instrutor instrutor = optionalInstrutor.get();
			curso.setInstrutor(instrutor);
			
			return cursoRepository.save(curso);
		}
		return null;
	}
	
	@GetMapping // Anotação para busca dos objetos em cursoRepository
	public List<Curso> listarCursos(){
		return cursoRepository.findAll();
	}
	
	@DeleteMapping("/{id}") // Anotação para Deletar um objeto através de um Id
	public void deletarCurso(@PathVariable Long id) {
		cursoRepository.deleteById(id);
	}
	
	@PutMapping("/{idCurso}/instrutor/{idInstrutor}") 
	// Anotação para Atualizar um objeto Curso existente, com adição de Instrutor
	public Curso atualizarCurso(@PathVariable Long idCurso, @PathVariable Long idInstrutor, @RequestBody Curso novoCurso) {
		
		Optional<Curso> optionalCurso = cursoRepository.findById(idCurso);
		Optional<Instrutor> optionalInstrutor = instrutorRepository.findById(idInstrutor);
		
		if(optionalCurso.isPresent() && optionalInstrutor.isPresent()) {
			
			Curso curso = optionalCurso.get();
			
			Instrutor instrutor = optionalInstrutor.get();
			
			curso.setInstrutor(instrutor);
			curso.setCargaHoraria(novoCurso.getCargaHoraria());
			curso.setNome(novoCurso.getNome());
			
			return cursoRepository.save(curso);
		}
		return null;
	}
}