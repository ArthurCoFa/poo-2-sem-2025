package exercicio6;

import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) {
		
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(2);
		a1.add(12);
		a1.add(100);
		a1.add(5);
		a1.add(6);
		a1.add(89);
		
		tiraPar(a1);
		
		System.out.println(a1);
	}
	
	public static void tiraPar(ArrayList<Integer> a) {
		
		for(int i = a.size() - 1; i > -1; i--) {
			
			if(a.get(i) % 2 == 0) {
				
				a.remove(i);
			}
		}
	}
}
