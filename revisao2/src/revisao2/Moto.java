package revisao2;

public class Moto extends Veiculo { // Herança: classe herda de Veiculo
	
	private boolean temPartidaEletrica;

	public boolean isTemPartidaEletrica() {
		return temPartidaEletrica;
	}

	public void setTemPartidaEletrica(boolean temPartidaEletrica) {
		this.temPartidaEletrica = temPartidaEletrica;
	}
	
	public double calcularImposto() { // Método para calcular imposto, 10%
		
		double preco;
		
		preco = getPreco() - (getPreco() * 0.02);
		
		return preco; // Retorna um double
	}
}
