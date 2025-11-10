package gestao_cursos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity(name = "rl_aluno_curso")
public class RlAlunoCurso {
	
	@EmbeddedId
	private RlAlunoCursoId id;
	
	@JsonIgnore
	@JsonManagedReference
	@ManyToOne
	@MapsId("idAluno")
	@JoinColumn(name = "tb_aluno_cd_aluno")
	private Aluno aluno;
	
	@JsonManagedReference
	@ManyToOne
	@MapsId("idCurso")
	@JoinColumn(name = "tb_curso_cd_curso")
	private Curso curso;
	
	public RlAlunoCurso() {
	}
	
	public RlAlunoCurso(Aluno aluno, Curso curso) {
		this.aluno = aluno;
		this.curso = curso;
		this.id = new RlAlunoCursoId(aluno.getIdAluno(), curso.getIdCurso());
	}

	public RlAlunoCursoId getId() {
		return id;
	}

	public void setId(RlAlunoCursoId id) {
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
