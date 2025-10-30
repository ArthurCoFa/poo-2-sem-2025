package questao5;

public class Principal {
	public static void main(String[] args) {
		
		Violino v1 = new Violino();
		Violino v2 = new Violino();
		
		Piano p1 = new Piano();
		Piano p2 = new Piano();
		
		v1.tocar();
		v2.tocar();
		p1.tocar();
		p2.tocar();
	}
}
