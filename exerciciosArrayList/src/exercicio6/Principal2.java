package exercicio6;

import java.util.ArrayList;

public class Principal2 {
	public static void main(String[] args) {
		
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(2);
		a1.add(12);
		a1.add(100);
		a1.add(7);
		a1.add(6);
		a1.add(91);
		
		System.out.println(tiraPar(a1));
	}
	
	public static ArrayList<Integer> tiraPar(ArrayList<Integer> a){
		
		ArrayList<Integer> resul = new ArrayList<Integer>();
		
		for(Integer elemento : a) {
			if(elemento % 2 != 0) {
				resul.add(elemento);
			}
		}
		return resul;
	}
}
