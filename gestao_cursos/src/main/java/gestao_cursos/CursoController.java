package gestao_cursos;

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
@RequestMapping("/api/cursos")
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	//Problema
	@PostMapping("/{idInstrutor}")
	public Curso salvarCurso(@PathVariable Long idInstrutor, @RequestBody Curso curso) {
		
		return cursoRepository.save(curso);
	}
	
	@DeleteMapping("/{id}")
	public void deletarCurso(@PathVariable Long id) {
		cursoRepository.deleteById(id);
	}
	
	@GetMapping
	public List<Curso> listarCursos(){
		return cursoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Curso> listarCursoId(@PathVariable Long id) {
		
		Optional<Curso> optionalCurso = cursoRepository.findById(id);
		
		if(optionalCurso.isPresent())	return optionalCurso;
		
		return null;
	}
	//problema
	@PutMapping("/curso/{idCurso}/instrutor/{idInstrutor}")
	public Curso atualizarCurso(@PathVariable Long idCurso, @RequestBody Curso novoCurso) {
		
		Optional<Curso> optionalCurso = cursoRepository.findById(idCurso);
		
		if(optionalCurso.isPresent()) {
			
			Curso curso = optionalCurso.get();
			
			curso.setCargaHoraria(novoCurso.getCargaHoraria());
			curso.setInstrutor(novoCurso.getInstrutor());
			curso.setCurso(novoCurso.getCurso());
			
			return cursoRepository.save(curso);
		}
		return null;
	}
}
