package revisao2;

public class Principal {
	
	public static void main(String[] args) {
		
		ContaBancaria b1 = new ContaBancaria("Arthur", "0001");
		
		b1.depositar(100);
		b1.sacar(20);
	
	}
}
