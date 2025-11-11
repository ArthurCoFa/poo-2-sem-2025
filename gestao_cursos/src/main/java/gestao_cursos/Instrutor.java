package gestao_cursos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_instrutor")
public class Instrutor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_instrutor")
	private Long idInstrutor;
	
	@Column(name = "nome_instrutor", nullable = false)
	private String nomeInstrutor;
	
	@Column(name = "idade")
	private int idade;
	
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "instrutor", cascade = CascadeType.ALL)
	private List<Curso> cursosMinistrados;
	
	public Instrutor() {	
	}
	
	public Instrutor(String nomeInstrutor, int idade) {
		this.nomeInstrutor = nomeInstrutor;
		this.idade = idade;
	}

	public Long getIdInstrutor() {
		return idInstrutor;
	}

	public void setIdInstrutor(Long idInstrutor) {
		this.idInstrutor = idInstrutor;
	}

	public String getNomeInstrutor() {
		return nomeInstrutor;
	}

	public void setNomeInstrutor(String nomeInstrutor) {
		this.nomeInstrutor = nomeInstrutor;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Curso> getCursosMinistrados() {
		return cursosMinistrados;
	}

	public void setCursosMinistrados(List<Curso> cursosMinistrados) {
		this.cursosMinistrados = cursosMinistrados;
	}
}
