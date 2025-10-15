package exercicio3;

import java.util.ArrayList;

public class Principal2 {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> array1 = new ArrayList<Integer>();
		array1.add(10);
		array1.add(15);
		array1.add(26);
		array1.add(35);
				
		ArrayList<Integer> array2 = new ArrayList<Integer>();
		array2.add(9);
		array2.add(11);
		array2.add(1);
		array2.add(35);
		array2.add(22);
		array2.add(10);
		
		System.out.println(juntarArrays(array1, array2));
	}
	
	public static ArrayList<Integer> juntarArrays(ArrayList<Integer> a1, ArrayList<Integer> a2) {
		
		ArrayList<Integer> resul = new ArrayList<Integer>();
		
		for(Integer num : a1) {
			
			if(!a2.contains(num)) {
				
				resul.add(num);
			}
		}
		for(Integer num2 : a2) {
			
			if(!a1.contains(num2)) {
				
				resul.add(num2);
			}
		}
		
		return resul;
	}
}
