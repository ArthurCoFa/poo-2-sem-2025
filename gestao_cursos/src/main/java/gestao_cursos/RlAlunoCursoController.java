package gestao_cursos;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
}
