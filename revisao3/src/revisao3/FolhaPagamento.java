package revisao3;

public class FolhaPagamento {
	
	public static void processar(Funcionario f) {
		
		System.out.println(f.getClass().getSimpleName() + " salário: " + f.calcularSalario());
	}
}
