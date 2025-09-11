package exercicio_11_09;

import java.util.ArrayList;

public class Questao_1 {
	
	public static void main(String[] args) {
		
		ArrayList<String> elementos = new ArrayList<String>();
		
		elementos.add("Carro");
		elementos.add("Peixe");
		elementos.add("jogos");
		elementos.add("dias");
		
		System.out.println(elementos.size());
		
		if(elementos.contains("Carro")) {
			
			System.out.println("Ele possui o elemento Carro.");
		}
	}
}
