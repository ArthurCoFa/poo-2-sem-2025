package curso;

import java.util.ArrayList;
import java.util.List;

import aluno.Aluno;
import instrutor.Instrutor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nomeCurso;
	
	@Column(nullable = false)
	private int cargaHoraria;
	
	@ManyToOne
	@JoinColumn(name = "instrutor_id")
	private Instrutor instrutor;
	
	@ManyToMany
	@JoinTable(
		name = "curso_aluno",
		joinColumns = @JoinColumn(name = "curso_id"),
		inverseJoinColumns = @JoinColumn(name = "aluno_id")
	)
	private List<Aluno> alunos = new ArrayList<>();
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}	
}
