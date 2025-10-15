package revisao3;

public class Estagiario extends Funcionario {
	
	private double auxilioTransporte;
	
	public double calcularSalario() {		
		return this.getSalarioBase() + auxilioTransporte;
	}

	public double getAuxilioTransporte() {
		return auxilioTransporte;
	}

	public void setAuxilioTransporte(double auxilioTransporte) {
		this.auxilioTransporte = auxilioTransporte;
	}
}
