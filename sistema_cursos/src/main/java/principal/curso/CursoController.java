package principal.curso;

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

import principal.instrutor.Instrutor;
import principal.instrutor.InstrutorRepository;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private InstrutorRepository instrutorRepository;
	
	@PostMapping("/{id}")
	public Curso adicionarCurso(@PathVariable Long id, @RequestBody Curso curso) {
		
		Optional<Instrutor> optionalInstrutor = instrutorRepository.findById(id);
		
		if(optionalInstrutor.isPresent()) {
			
			Instrutor instrutor = optionalInstrutor.get();
			curso.setInstrutor(instrutor);
			
			return cursoRepository.save(curso);
		}
		return null;
	}
	
	@GetMapping
	public List<Curso> listarCursos(){
		return cursoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Curso> listarCursoId(@PathVariable Long id) {
		
		Optional<Curso> optionalCurso = cursoRepository.findById(id);
		
		if(optionalCurso.isPresent()) {
			return optionalCurso;
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deletarCurso(@PathVariable Long id) {
		cursoRepository.deleteById(id);
	}
	
	@PutMapping("/{idCurso}/{idInstrutor}")
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
