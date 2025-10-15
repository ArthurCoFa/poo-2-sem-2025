package exercicio4;

import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) {
		
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(2);
		a1.add(35);
		a1.add(100);
		a1.add(5);
		a1.add(6);
		a1.add(89);
		
		System.out.println(indiceMaior(a1));
	}
	
	public static int indiceMaior(ArrayList<Integer> array) {
		
		int elemento = 0, indice = 0;
		
		for(int i = 0; i < array.size(); i++) {
			
			if(array.get(i) > elemento) {
				
				elemento = array.get(i);
				indice = i;
			}
		}
		
		return indice;
	}
}
