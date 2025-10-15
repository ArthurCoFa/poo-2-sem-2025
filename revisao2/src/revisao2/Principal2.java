package revisao2;

import java.util.ArrayList;

public class Principal2 {
	
	public static void main(String[] args) {
		
		Carro c1 = new Carro();
		c1.setMarca("vw");
		c1.setModelo("Gol");
		c1.setNumerosPortas(4);
		c1.setPreco(30000);
		
		Moto m1 = new Moto();
		m1.setMarca("yamaha");
		m1.setModelo("hornet");
		m1.setPreco(12000);
		
		Caminhao k1 = new Caminhao();
		k1.setCapacidadeCarga(10);
		k1.setMarca("Volvo");
		k1.setModelo("não sei modelos de caminhão");
		k1.setPreco(50000);
		
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		veiculos.add(c1);
		veiculos.add(m1);
		veiculos.add(k1);
		
		for(int i = 0; i < veiculos.size(); i++) {
			
			System.out.println(veiculos.get(i).getClass().getSimpleName() + ": " + veiculos.get(i).calcularImposto());
		}
		
		System.out.println();
		
		for(Veiculo elemento : veiculos) { // Outra forma de percorrer o arrayList
			
			System.out.println(elemento.getClass().getSimpleName() + ": " + elemento.calcularImposto());
		}
		
	}
}
