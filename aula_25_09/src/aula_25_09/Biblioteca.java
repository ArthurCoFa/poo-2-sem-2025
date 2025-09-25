package aula_25_09;

import java.util.ArrayList;

public class Biblioteca {
	
	public Biblioteca() { // Construtor padrão
		
	}
	
	public Biblioteca(ArrayList<Livro> livro) {
		
		this.livros = livro;
	}
	
	private String nome;
	private ArrayList<Livro> livros = new ArrayList<Livro>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Livro> getLivros() {
		return livros;
	}
	public void setLivros(ArrayList<Livro> livros) {
		this.livros = livros;
	}
	
}
