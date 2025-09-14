package exercicio_11_09;

import java.util.ArrayList;

public class Questao_10 {
	
	public static ArrayList<String> reverso (ArrayList<String> a) {
		
		ArrayList<String> inverso = new ArrayList<String>();
		
		for(int i = a.size() - 1; i >= 0; i--) {
			
			inverso.add(a.get(i));
		}
		
		return inverso;
	}
	
	public static void main(String[] args) {
		
		ArrayList<String> normal = new ArrayList<String>();
		
		normal.add("casa");
		normal.add("braco");
		normal.add("vaso");
		normal.add("mantimentos");
		normal.add("pao");
		
		System.out.println(reverso(normal));
	}
}
