package projetoGestaoCursos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projetoGestaoCursos.model.Aluno;
import projetoGestaoCursos.model.Curso;
import projetoGestaoCursos.repository.AlunoRepository;
import projetoGestaoCursos.repository.CursoRepository;

@RestController // Anotação para deixar endpoint de @RequestMapping ativo e recebendo requisições
@RequestMapping("/api/cursoAluno") // Anotação para indicar o endpoint para usar os métodos
public class CursoAlunoController {

	@Autowired // Anotação que cria um objeto do repository para usar nos métodos
	private AlunoRepository alunoRepository;
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping // Anotação que busca todos os objetos de Curso, junto aparece os alunos em cada curso
	public List<Curso> listarCursosAlunos(){
		return cursoRepository.findAll();
	}
	
	@PostMapping("/{idAluno}/{idCurso}") // Anotação para salvar/criar relacionamento entre aluno e curso
	public Curso salvarAlunosCurso(@PathVariable Long idAluno, @PathVariable Long idCurso) {
		
		Optional<Aluno> optionalAluno = alunoRepository.findById(idAluno);
		
		Optional<Curso> optionalCurso = cursoRepository.findById(idCurso);
		
		if(optionalAluno.isPresent()) {
			
			Aluno aluno = optionalAluno.get();
			
			Curso curso = optionalCurso.get();
			
			curso.getAlunos().add(aluno);
			
			return cursoRepository.save(curso);
		}
		return null;
	}
	
	@DeleteMapping("/{idAluno}/{idCurso}") // Anotação para Deletar Aluno de um Curso
	public Curso deletarAlunosCurso(@PathVariable Long idAluno, @PathVariable Long idCurso) {
		
		Optional<Curso> optionalCurso = cursoRepository.findById(idCurso);
		
		Optional<Aluno> opionalAluno = alunoRepository.findById(idAluno);
		
		if(opionalAluno.isPresent() && optionalCurso.isPresent()) {
			Aluno aluno = opionalAluno.get();
			
			Curso curso = optionalCurso.get();
			
			curso.getAlunos().remove(aluno);
			
			return cursoRepository.save(curso);
		}
		return null;
	}
}
