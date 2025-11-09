package exemplo_casa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Alunos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome é OBRIGATÓRIO!")
	private String nome;
	
	@Min(value = 0, message = "A idade não pode ser negativa!")
	@NotNull(message = "A idade é OBRIGATÓRIA!")
	private int idade;
	
	@Column(unique = true)
	private String matricula;
	
	@Override
	public String toString() {
        return "Aluno [idAluno=" + id + 
               ", nome=" + nome + 
               ", idade=" + idade + 
               "]";
    }
	
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
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}
