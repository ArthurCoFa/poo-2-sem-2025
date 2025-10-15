package revisao2;

public class Caminhao extends Veiculo { // Herança: classe herda de Veiculo
	
	private int capacidadeCarga;

	public int getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(int capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}
	
	public double calcularImposto() { // Método para calcular imposto, 10%
		
		double preco;
		
		preco = getPreco() - (getPreco() * 0.08);
		
		return preco; // Retorna um double
	}
}
