package exercicio_11_09;

import java.util.ArrayList;

public class Questao_9 {
	
	public static float media(ArrayList<Integer> a) {
		
		float media = 0;
		
		for(int i = 0; i < a.size(); i++) {
			
			media += a.get(i);
		}
			
		return media / a.size();
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		lista.add(12);
		lista.add(20);
		lista.add(10);
		lista.add(11);
		
		System.out.println(media(lista));
	}
}
