package gestao_cursos;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_curso")
	private Long idCurso;
	
	@Column(name = "curso", nullable = false)
	private String curso;
	
	@Column(name = "carga_horaria", nullable = false)
	private int cargaHoraria;
	
	@ManyToOne
	@JoinColumn(name = "tb_instrutor_cd_instrutor")
	private Instrutor instrutor;
	
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
	private Set<RlAlunoCurso> matriculas;
	
	public Curso() {
	}
	
	public Curso(String curso, int cargaHoraria, Instrutor instrutor) {
		this.curso = curso;
        this.cargaHoraria = cargaHoraria;
        this.instrutor = instrutor;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public Set<RlAlunoCurso> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<RlAlunoCurso> matriculas) {
		this.matriculas = matriculas;
	}
}
