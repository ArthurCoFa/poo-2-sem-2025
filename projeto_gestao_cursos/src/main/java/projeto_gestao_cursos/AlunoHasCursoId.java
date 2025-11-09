package projeto_gestao_cursos;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class AlunoHasCursoId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idAluno;
	private Long idCurso;
	
	@Override
	public boolean equals(Object o) {
		
		if(this == o) return true;
		
		if(o == null || getClass() != o.getClass()) return false;
		
		AlunoHasCursoId that = (AlunoHasCursoId) o;
		
		return Objects.equals(idAluno, that.idAluno) && 
			   Objects.equals(idCurso, that.idCurso);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idAluno, idCurso);
	}
	
	public AlunoHasCursoId() {}
	
	public AlunoHasCursoId(Long idAluno, Long idCurso) {
		this.idAluno = idAluno;
		this.idCurso = idCurso;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}
}
