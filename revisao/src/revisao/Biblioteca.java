package revisao;

public class Biblioteca {
	
	private String nome;
	private Livro livro;// Agregação
	
	public Biblioteca(String nome) {
		this.nome = nome;
	}
	public Biblioteca() {
		
	}
	public void emprestar() {
		System.out.println("Emprestado");
	}
	public void emprestar(String tipo) {
		System.out.println(tipo + "emprestado"); /// Não possui herança então sobrescrita
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}
