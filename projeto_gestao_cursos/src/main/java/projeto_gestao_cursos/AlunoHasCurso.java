package projeto_gestao_cursos;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno_has_curso")
public class AlunoHasCurso {

	@EmbeddedId
	private AlunoHasCursoId id;
	
	@ManyToOne
	@MapsId("idAluno")
	@JoinColumn(name = "Aluno_idAluno")
	private Aluno aluno;
	
	@ManyToOne
	@MapsId("idCurso")
	@JoinColumn(name = "Curso_idCurso")
	private Curso curso;
	
	public AlunoHasCurso() {}
	
	public AlunoHasCurso(Aluno aluno, Curso curso) {
		this.aluno = aluno;
		this.curso = curso;
		this.id = new AlunoHasCursoId(aluno.getIdAluno(), curso.getIdCurso());
	}

	public AlunoHasCursoId getId() {
		return id;
	}

	public void setId(AlunoHasCursoId id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
