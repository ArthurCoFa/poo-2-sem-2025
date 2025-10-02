package revisao;

public class Livro {
	
	private String autor;
	private String titulo;
	private int ano;
	
	public void imprimeInformacoes() {
		System.out.println("livro: "+ titulo);
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
}
