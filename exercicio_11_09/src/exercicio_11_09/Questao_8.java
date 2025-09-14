package exercicio_11_09;

import java.util.ArrayList;

public class Questao_8 {
	
	public static ArrayList<String> letra (ArrayList<String> a, char b){
		
		ArrayList<String> letras = new ArrayList<String>(); 
		
		for(int i = 0; i < a.size(); i++) {
			
			if(a.get(i).charAt(0) == b) {
				
				letras.add(a.get(i));
			}
		}
		
		return letras;
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> palavras = new ArrayList<String>();
		
		palavras.add("casa");
		palavras.add("dormitorio");
		palavras.add("banheiros");
		palavras.add("amanha");
		palavras.add("escola");
		palavras.add("armario");
		
		System.out.println(letra(palavras, 'd'));
	}
}
