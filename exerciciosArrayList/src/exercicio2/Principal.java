package exercicio2;

import java.util.ArrayList;

public class Principal {
	
	public static void main(String[] args) {
		
		ArrayList<String> s1 = new ArrayList<String>();
		s1.add("maça");
		s1.add("banana");
		s1.add("banana");
		s1.add("melao");
		s1.add("batata");
		
		System.out.println(contarUnicos(s1));
		
	}
	
	public static int contarUnicos(ArrayList<String> arraylist) {
		
		ArrayList<String> elementosUnicos = new ArrayList<String>();
		
		for (String elemento : arraylist) {
		    
		    if (!elementosUnicos.contains(elemento)) {
		        
		    		elementosUnicos.add(elemento);
		    }
		}
		
		return elementosUnicos.size();
	}
	
	public static int contarUnicos2(ArrayList<String> arraylist) {
		
		int qtd = 0;
		
		for(int i = arraylist.size() - 1; i > 0; i--) {
			
			for(int j = 0; j < i; j++) {
				
				if(arraylist.get(i) == arraylist.get(j)) {
					
					qtd++;
				}
			}
		}
		return arraylist.size() - qtd;
	}
}
