package projeto_gestao_cursos;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCurso;
	
	@Column(name = "nome_curso")
	@NotBlank
	private String nomeCurso;
	
	@Column(name = "carga_horaria")
	@NotNull
	private int cargaHoraria;
	
	@ManyToOne
	@JoinColumn(name = "Instrutor_idInstrutor")
	private Instrutor instrutor;
	
	@OneToMany(mappedBy = "curso")
	private Set<AlunoHasCurso> matriculas = new HashSet<>();
	
	public Curso() {}
	
    public Curso(String nomeCurso, int cargaHoraria) {
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
    }
	
	public void adicionarMatricula(AlunoHasCurso matricula) {
        this.matriculas.add(matricula);
    }
	
	public Set<AlunoHasCurso> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<AlunoHasCurso> matriculas) {
		this.matriculas = matriculas;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
}
