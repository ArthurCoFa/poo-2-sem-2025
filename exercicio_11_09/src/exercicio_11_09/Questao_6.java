package exercicio_11_09;

import java.util.ArrayList;

public class Questao_6 {
	
	public static void tiraPar(ArrayList<Integer> a) {
		
		for(int i = a.size() - 1; i > 0; i--) {
			
			if(a.get(i) % 2 == 0) {
				
				a.remove(i);
			}
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		num.add(1);
		num.add(0);
		num.add(2);
		num.add(4);
		num.add(5);
		num.add(6);
		
		System.out.println(num);
		
		tiraPar(num);
		
		System.out.println(num);
	}
}
