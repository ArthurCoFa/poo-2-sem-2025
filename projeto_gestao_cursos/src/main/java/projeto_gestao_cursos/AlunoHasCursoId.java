package projeto_gestao_cursos;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class AlunoHasCursoId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long tb_aluno_id_aluno;
	private Long tb_curso_id_curso;
	
	@Override
	public boolean equals(Object o) {
		
		if(this == o) return true;
		
		if(o == null || getClass() != o.getClass()) return false;
		
		AlunoHasCursoId that = (AlunoHasCursoId) o;
		
		return Objects.equals(tb_aluno_id_aluno, that.tb_aluno_id_aluno) && 
			   Objects.equals(tb_curso_id_curso, that.tb_curso_id_curso);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(tb_aluno_id_aluno, tb_curso_id_curso);
	}
	
	public AlunoHasCursoId() {}
	
	public AlunoHasCursoId(Long tb_aluno_id_aluno, Long tb_curso_id_curso) {
		this.tb_aluno_id_aluno = tb_aluno_id_aluno;
		this.tb_curso_id_curso = tb_curso_id_curso;
	}

	public Long getTb_aluno_id_aluno() {
		return tb_aluno_id_aluno;
	}

	public void setTb_aluno_id_aluno(Long tb_aluno_id_aluno) {
		this.tb_aluno_id_aluno = tb_aluno_id_aluno;
	}

	public Long getTb_curso_id_curso() {
		return tb_curso_id_curso;
	}

	public void setTb_curso_id_curso(Long tb_curso_id_curso) {
		this.tb_curso_id_curso = tb_curso_id_curso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
