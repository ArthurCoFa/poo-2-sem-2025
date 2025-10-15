package revisao2;

public class Carro extends Veiculo { // Herança: classe herda de Veiculo
	
	private int numerosPortas;

	public int getNumerosPortas() {
		return numerosPortas;
	}

	public void setNumerosPortas(int numerosPortas) {
		this.numerosPortas = numerosPortas;
	}
	
	// Sobrescrita
	public double calcularImposto() { // Método para calcular imposto, 10%
		
		double preco;
		
		preco = getPreco() - (getPreco() * 0.05);
		
		return preco; // Retorna um double
	}
}
