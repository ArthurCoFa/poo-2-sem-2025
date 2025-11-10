package gestao_cursos;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class RlAlunoCursoId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "tb_aluno_cd_aluno")
	private Long idAluno;
	
	@Column(name = "tb_curso_cd_curso")
	private Long idCurso;
	
	public RlAlunoCursoId() {
	}
	
	public RlAlunoCursoId(Long idAluno, Long idCurso) {
		this.idAluno = idAluno;
		this.idCurso = idCurso;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (this == o) return true;
		
		if (o == null || getClass() != o.getClass()) return false;
		
		RlAlunoCursoId that = (RlAlunoCursoId) o;
		
		return Objects.equals(idAluno, that.idAluno) &&
			   Objects.equals(idCurso, that.idCurso);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idAluno, idCurso);
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
