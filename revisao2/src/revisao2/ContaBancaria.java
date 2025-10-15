package revisao2;

public class ContaBancaria {
	
	// Atributos (encapsulados)
	private String titular;
	private String numeroConta;
	private double saldo;
	
	// Construtor
	public ContaBancaria(String titular, String numeroConta) {
		this.titular = titular;
		this.numeroConta = numeroConta;
		this.saldo = 0.0;
	}
	
	// Métodos
	public void depositar(double valor) {
		
		if(valor > 0) {
			this.saldo += valor;
			System.out.println("Foi depositado " + valor + " reais\n"
					           + "Seu saldo é de " + this.saldo + " reais");
		} else {
			
			System.out.println("Não é possível depositar esse valor.");
		}
	}
	public boolean sacar(double valor) {
		
		if(valor > 0 && valor <= saldo) {
			this.saldo -= valor;
			System.out.println("Você sacou " + valor + " reais\n"
					           + "Seu saldo é de " + this.saldo + " reais");
			return true;
		} else {
			
			System.out.println("Seu saldo é menor do que o valor que digitou ou o valor é indevido.");
			return false;
		}
	}
	
	// Getters e setters

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
