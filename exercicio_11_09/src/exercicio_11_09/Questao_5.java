package exercicio_11_09;

import java.util.ArrayList;

public class Questao_5 {

	public static int ocorrencia (ArrayList<String> a, int b) {
		
		int o = 0;
		
		for(int i = 0; i < a.size(); i++) {
			
			if(a.get(i) == a.get(b)) {
				
				o++;
			}
		}
		
		return o;
	}
	
	public static void main(String[] args) {
		
		int b = 2;
		
		ArrayList<String> nomes = new ArrayList<String>();
		
		nomes.add("a");
		nomes.add("b");
		nomes.add("c");
		nomes.add("b");
		nomes.add("c");
		
		System.out.println(ocorrencia(nomes, b));
	}
}
