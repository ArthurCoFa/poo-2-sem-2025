package exercicio5;

import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) {
		
		ArrayList<String> array = new ArrayList<String>();
		array.add("maca");
		array.add("banana");
		array.add("sug");
		array.add("bruh");
		array.add("melan");
		array.add("melao");
		array.add("maca");
		
		System.out.println(numeroOcorrencias(array, "maca"));
	}
	
	public static int numeroOcorrencias(ArrayList<String> a, String selecionada) {
		
		int ocorrencias = 0;
		
		for(int i = 0; i < a.size(); i++) {
			
			if(a.get(i) == selecionada) {
				
				ocorrencias++;
			}	
		}
		
		return ocorrencias;
	}
}
