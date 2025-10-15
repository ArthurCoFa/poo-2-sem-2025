package revisao2;

public class Veiculo { // Abstração do veículo são as informações importantes dele
	// Encapsulamento: Atributos privados
	private String marca; 
	private String modelo; 
	private double preco;
	// Atributos
	
	public Veiculo() { // Construtor padrão
	}
	
	// getters and setters
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		// Impede que o preço seja menor que 0
		if(preco > 0) {
			this.preco = preco;
			
		} else {
			
			System.out.println("O preço tem um valor indevido.");
		}
	}
	
	public double calcularImposto() { // Método para calcular imposto, 10%
		
		this.preco = this.preco - (this.preco * 0.1);
		
		return this.preco; // Retorna um double
	}
}
