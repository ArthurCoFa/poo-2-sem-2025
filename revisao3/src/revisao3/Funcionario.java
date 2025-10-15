package revisao3;

public class Funcionario {
	
	private String nome;
	private String cpf;
	private double salarioBase;
	
	public Funcionario() {
	}
	
	public double calcularSalario() {		
		return this.salarioBase;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
}
