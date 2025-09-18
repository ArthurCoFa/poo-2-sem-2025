package aula_18_09;

public class Aluno {
	
	private String nome;
	private String ra;
	private Endereco endereco;
	private Email email;
	
	public Aluno() {
	}
	
	public Aluno(String nome, Endereco endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}

}
