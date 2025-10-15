package revisao3;

public class Gerente extends Funcionario {
	
	private double bonusAnual;
	
	public double calcularSalario() {
		
		return this.getSalarioBase() + bonusAnual;
	}

	public double getBonusAnual() {
		return bonusAnual;
	}

	public void setBonusAnual(double bonusAnual) {
		this.bonusAnual = bonusAnual;
	}
}
