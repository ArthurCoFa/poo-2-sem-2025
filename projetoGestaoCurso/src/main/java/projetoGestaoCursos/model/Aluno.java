package projetoGestaoCursos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Anotação para dizer que a classe é uma tabela
public class Aluno {
	
	@Id // Anotação para identificar atributo Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Anotação para geração automática do Id
	private Long id;
	
	@Column(nullable = false) // Anotação Column com nullable = false, não pode ser nulo
	private String nome;
	
	@Column(nullable = false)
	private int idade;
	
	@Column(length = 11, nullable = false, unique = true) // length 11, pois cpf tem 11 números, unique porque cpf é único
	private String cpf;

	// Getters e Setters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
}