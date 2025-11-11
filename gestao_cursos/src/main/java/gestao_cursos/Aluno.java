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
import jakarta.persistence.OneToMany;

@Entity(name = "tb_aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_aluno")
	private Long idAluno;
	
	@Column(name = "nome_aluno", nullable = false, length = 255)
	private String nomeAluno;
	
	@Column(name = "idade")
	private int idade;
	
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
	private Set<RlAlunoCurso> matriculas;
	
	public Aluno() {
	}
	
	public Aluno(String nomeAluno, int idade) {
		this.nomeAluno = nomeAluno;
		this.idade = idade;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Set<RlAlunoCurso> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<RlAlunoCurso> matriculas) {
		this.matriculas = matriculas;
	}
}
