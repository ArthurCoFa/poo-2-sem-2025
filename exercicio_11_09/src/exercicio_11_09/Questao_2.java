package exercicio_11_09;

import java.util.ArrayList;

public class Questao_2 {
	
	public static int elemUnicos(ArrayList<String> e) {
		
		int n = 0;
		int a = 0;
		
		for(int i = 0; i < e.size(); i++) {
			
			n = 0;
			
			for(int j = 0; j < e.size(); j++) {
				
				if(e.get(i) == e.get(j) && i != j) {
					
					n++;	
				}
			}
			
			if(n == 0) {
				
				a++;
			}		
		}
		
		return a;
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> elementosDup = new ArrayList<String>();
		
		elementosDup.add("a");
		elementosDup.add("b");
		elementosDup.add("a");
		elementosDup.add("c");
		elementosDup.add("c");
		elementosDup.add("d");
		
		System.out.println(elementosDup);
		
		System.out.println(elemUnicos(elementosDup));
	}
}
