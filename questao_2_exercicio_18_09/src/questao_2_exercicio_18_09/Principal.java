package questao_2_exercicio_18_09;

public class Principal {
	
	public static void main(String[] args) {
		
		Processador p1 = new Processador();
		p1.setFrequencia("3 GHz");
		p1.setMarca("Intel");
		
		MemoriaRam m1 = new MemoriaRam();
		m1.setCapacidade("32 GB");
		m1.setTipo("DDR4");
		
		Computador c1 = new Computador(p1, m1);
		
		c1.exibirDetalhes();
	}
}
