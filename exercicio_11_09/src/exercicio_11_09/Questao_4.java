package exercicio_11_09;

import java.util.ArrayList;

public class Questao_4 {

	public static int indiceMenorNum(ArrayList<Integer> a) {
		
		int b = 0;
		int c = 0;
		
		for(int i = 0; i < a.size(); i++) {
			
			if(b < a.get(i)) {
				
				b = a.get(i);
				c = i;
			}
		}
		
		return c;
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		numeros.add(30);
		numeros.add(1);
		numeros.add(6);
		numeros.add(10);
		numeros.add(42);
		numeros.add(9);
		
		System.out.println(indiceMenorNum(numeros));
	}
}
