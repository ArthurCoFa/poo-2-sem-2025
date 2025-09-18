package questao_3_exercicio_18_09;

public class Departamento {
	
	private String nomeDepartamento;
	private Universidade universidade;
	
	public Departamento(Universidade universidade) {
		this.universidade = universidade;
	}
	public Universidade getUniversidade() {
		return universidade;
	}
	public void setUniversidade(Universidade universidade) {
		this.universidade = universidade;
	}
	public String getNomeDepartamento() {
		return nomeDepartamento;
	}
	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}
	
}
