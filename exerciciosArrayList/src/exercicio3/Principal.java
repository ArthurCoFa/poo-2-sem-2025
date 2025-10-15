package exercicio3;

import java.util.ArrayList;

public class Principal {
	
	public static void main(String[] args) {
		
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("maca");
		a1.add("pera");
		a1.add("banana");
		a1.add("fruta loca");
		a1.add("n pensei");
		
		ArrayList<String> a2 = new ArrayList<String>();
		a2.add("maca");
		a2.add("banana");
		a2.add("melancia");
		a2.add("mamao");
		a2.add("melancia");
		a2.add("loco");
		a2.add("pequi");
		
		ArrayList<String> j = new ArrayList<String>();
		
		j = juntarArrayList(a1, a2);
		
		System.out.println(j);
	}
	
	public static ArrayList<String> juntarArrayList(ArrayList<String> array1, ArrayList<String> array2){
		
		ArrayList<String> juncao = new ArrayList<String>();
		
		ArrayList<String> mesmos = new ArrayList<String>();
		
		int x = 0;
				
		for(int i = 0; i < array1.size() && i < array2.size(); i++) {
			
			for(int j = 0; j < array1.size() && j < array2.size(); j++) {
						
				if(array1.get(i) == array1.get(j) && i != j) {
							
					array1.remove(j);
					array1.remove(i);
				}
				
				if(array2.get(i) == array2.get(j) && i != j) {
							
					array2.remove(j);
					array2.remove(i);
				}
			}			
		}
				
//		System.out.println(array1 + "\n" + array2);
		
		for(int i = 0; i < array1.size() && i < array2.size(); i++) {
			
			x = 0;
			
			for(int j = 0; j < array1.size() && j < array2.size(); j++) {
				
				if(array1.get(i) == array2.get(j)) {
					
					x++;
				}
			}
			if(x != 0) {
				
				mesmos.add(array1.get(i));
			}
		}
		
		juncao.addAll(array2);
		juncao.addAll(array1);
		
		juncao.removeAll(mesmos);
		
		return juncao;
	}
}
