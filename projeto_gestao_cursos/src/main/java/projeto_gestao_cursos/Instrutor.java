package projeto_gestao_cursos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Instrutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInstrutor;
	
	@Column(name = "nome_intrutor")
	@NotBlank
	private String nomeInstrutor;
	
	@NotBlank
	private String cpf;

	@OneToMany(mappedBy = "instrutor")
	private List<Curso> cursos;
	
	public Instrutor() {}
	
    public Instrutor(String nomeInstrutor, String cpf) {
        this.nomeInstrutor = nomeInstrutor;
        this.cpf = cpf;
    }
	
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
