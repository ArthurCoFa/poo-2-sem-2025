package projeto_gestao_cursos;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private Long idCurso;
	
	@Column(name = "nome_curso", length = 50, nullable = false)
	@NotBlank(message = "O nome do curso é obrigatório!")
	private String nomeCurso;
	
	@Min(value = 1, message = "A carga horária deve ser pelo menos 1 hora.")
	@NotNull(message = "A carga horária é obrigatória!")
	@Column(name = "carga_horaria", nullable = false)
	private int cargaHoraria;
	
	@ManyToOne
	@JoinColumn(name = "tb_instrutor_id_instrutor")
	private Instrutor instrutor;
	
	@OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<AlunoHasCurso> matriculas = new HashSet<>();
	
	public Curso() {}
	
    public Curso(String nomeCurso, int cargaHoraria, Instrutor instrutor) {
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.instrutor = instrutor;
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
