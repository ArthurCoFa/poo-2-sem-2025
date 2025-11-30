package projetoGestaoCursos.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity // Anotação para dizer que a classe é uma tabela
public class Curso {

	@Id // Anotação para identificar atributo Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação para geração automática do Id
	private Long id;
	
	@Column(nullable = false) // Anotação Column com nullable = false, não pode ser nulo
	private String nome;
	
	@Column(nullable = false)
	private int cargaHoraria;
	
	@ManyToOne // Anotação que indica que vários cursos possuem somente 1 instrutor
	private Instrutor instrutor;
	
	@ManyToMany // Anotação que indica um relacionamento de vários cursos para vários alunos
	@JoinTable(
		name = "curso_aluno", // Nome da tabela de relacionamento
		joinColumns = @JoinColumn(name = "curso_id"), // Id da classe curso
		inverseJoinColumns = @JoinColumn(name = "aluno_id") // Id da classe aluno
	)
	private List<Aluno> alunos = new ArrayList<>(); // Lista de alunos que serão relacionados aos cursos

	// Getters e Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
}