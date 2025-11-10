package projeto_gestao_cursos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_instrutor")
public class Instrutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_instrutor")
	private Long idInstrutor;
	
	@Column(name = "nome_instrutor", length = 50, nullable = false)
	@NotBlank(message = "O nome do instrutor é obrigatório!")
	private String nomeInstrutor;
	
	@NotBlank(message = "O CPF não pode ser vazio!")
	@Column(name = "cpf", length = 11, nullable = false, unique = true)
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
