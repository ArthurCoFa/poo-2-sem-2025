package revisao3;

public class Desenvolvedor extends Funcionario {
	
	private int projetosConcluidos;
	
	public double calcularSalario() {		
		return this.getSalarioBase() + (projetosConcluidos * 100);
	}

	public int getProjetosConcluidos() {
		return projetosConcluidos;
	}

	public void setProjetosConcluidos(int projetosConcluidos) {
		this.projetosConcluidos = projetosConcluidos;
	}
}
