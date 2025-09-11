package aula0409;

public class Automovel {
	
	private String marca; // Criação do atributo do tipo String, s maiusculo por causa que é uma classe
	private String modelo; // Criação do atributo do tipo String 
	private int ano; // Criação do atributo do tipo int
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo.toUpperCase();
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	// Sobrecarga

	public void ligar() { // Criação do método sem parâmetro
		
		System.out.println("Automovel ligado!");
	}
	
	public void ligar(boolean usouAfogador) { // Criação do método com parâmetro
		
		if(usouAfogador) {
			
			System.out.println("Automovel ligado!");
		} else {
			
			System.out.println("Automovel Afogado!");
		}
	}
}
