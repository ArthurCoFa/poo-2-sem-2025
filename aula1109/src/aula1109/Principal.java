package aula1109;

import java.util.ArrayList;

public class Principal {
	
	public static void main(String[] args) {
		
		ArrayList<String> disciplinas = new ArrayList<String>();
		
		disciplinas.add("Cálculo II");
		disciplinas.add("Álgebra Linear");
		disciplinas.add("Circuitos elétricos");
		disciplinas.add("Cálculo III");
		
		System.out.println(disciplinas);
		
		System.out.println(disciplinas.get(2));
		
		disciplinas.set(3, "Cálculo IV");
		
		System.out.println(disciplinas);
		
		disciplinas.remove(2);
		
		System.out.println(disciplinas);
		
		System.out.println(disciplinas.get(2));
		
		for(int i = 0;  i < disciplinas.size(); i++) {
			
			System.out.println(disciplinas.get(i));
		}
		
		System.out.println(disciplinas.contains("Cálculo II"));
	}
}
