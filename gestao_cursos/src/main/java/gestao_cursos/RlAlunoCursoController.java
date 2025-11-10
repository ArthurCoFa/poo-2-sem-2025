package gestao_cursos;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RlAlunoCursoController {
	
	@Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private RlAlunoCursoRepository rlAlunoCursoRepository;
    
    @PostMapping("/alunos/{alunoId}/cursos/{cursoId}")
    public ResponseEntity<RlAlunoCurso> matricularAluno(@PathVariable Long idAluno, 
                                                        @PathVariable Long idCurso){
    	
    	try {
            // Busca simplificada: se não encontrar, lança NoSuchElementException (Gera 500 ou 404)
            Aluno aluno = alunoRepository.findById(idAluno).get();
            Curso curso = cursoRepository.findById(idCurso).get();

            // Cria e salva o objeto
            RlAlunoCurso novaMatricula = new RlAlunoCurso(aluno, curso);
            RlAlunoCurso matriculaSalva = rlAlunoCursoRepository.save(novaMatricula);
            
            return new ResponseEntity<>(matriculaSalva, HttpStatus.CREATED);
            
        } catch (NoSuchElementException e) {
            // Captura o erro se o aluno ou curso não for encontrado
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }
}
