package agregacaoComposicao;

public class Pessoa {
	
	private String nome;
	private int id;
	
	public String obterInformacoes() {
		
		return "Nome: " + this.getNome()+ " - CPF: " + this.getId();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
