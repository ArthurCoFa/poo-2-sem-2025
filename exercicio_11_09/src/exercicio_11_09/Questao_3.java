package exercicio_11_09;

import java.util.ArrayList;

public class Questao_3 {
	
	public static ArrayList<String> mesmosElementos(ArrayList<String> a, ArrayList<String> b) {
		
		ArrayList<String> mesmos = new ArrayList<String>();
		
		for(int i = 0; i < a.size(); i++) {
			
			for(int j = 0; j < b.size(); j++) {
				
				if(a.get(i) == b.get(j)) {
					
					mesmos.add(a.get(i));
				}
			}
		}
		
		return mesmos;
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> elem1 = new ArrayList<String>();
		
		elem1.add("planador");
		elem1.add("carro");
		elem1.add("bebe");
		elem1.add("joao");
		
		ArrayList<String> elem2 = new ArrayList<String>();
		
		elem2.add("carro");
		elem2.add("carlos");
		elem2.add("manuel");
		elem2.add("planador");
		elem2.add("carro");
		
		System.out.println(elem1);
		System.out.println(elem2);
		
		System.out.println(mesmosElementos(elem1, elem2));
	}
}
