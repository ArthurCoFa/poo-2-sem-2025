package projeto_gestao_cursos;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAluno;
	
	@Column(name = "nome_aluno")
	@NotBlank
	private String nomeAluno;
	
	@Min(value = 0)
	@NotNull
	private int idade;
	
	@OneToMany(mappedBy = "aluno")
	private Set<AlunoHasCurso> matriculas = new HashSet<>();
	
	@Override
    public String toString() {
        return "Aluno [id=" + idAluno + 
        		   ", nome=" + nomeAluno + 
        		   ", idade=" + idade + "]";
    }
	
	public Aluno() {	}
	
	public Aluno(String nomeAluno, int idade) {
		this.nomeAluno = nomeAluno;
		this.idade = idade;
	}
	
	public Set<AlunoHasCurso> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Set<AlunoHasCurso> matriculas) {
		this.matriculas = matriculas;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
