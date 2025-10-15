package exercicio1;

import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) {
		
		ArrayList<String> s1 = new ArrayList<String>();
		s1.add("Maça");
		s1.add("Banana");
		
		System.out.println(s1.size());
		
		System.out.println("Vermelho 'is " + s1.contains("Vermelho") + "' na lista");
	}
}
