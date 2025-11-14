package principal.cursoAluno;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import principal.aluno.Aluno;
import principal.aluno.AlunoRepository;
import principal.curso.Curso;
import principal.curso.CursoRepository;

@RestController
@RequestMapping("/api/cursoAluno")
public class CursoAlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<Curso> listarCursosAlunos(){
		return cursoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Curso listarCursoAlunosId(@PathVariable Long id) {
		Optional<Curso> optionalCurso = cursoRepository.findById(id);
		
		if(optionalCurso.isPresent()) {
			
			Curso curso = optionalCurso.get();
			
			return curso;
		}
		return null;
	}
	
	@PostMapping("/{idAluno}/{idCurso}")
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
	
	@DeleteMapping("/{idAluno}/{idCurso}")
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
