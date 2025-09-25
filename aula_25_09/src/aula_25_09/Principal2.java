package aula_25_09;

import java.util.ArrayList;

public class Principal2 {
	
	public static void main(String[] args) { // Composição
		
		Livro l1 = new Livro();
		l1.setAutor("Felipe");
		l1.setTitulo("Cálculo II");
		l1.setAnoPublicacao(2020);
		
		Livro l2 = new Livro();
		l2.setAutor("Carlos");
		l2.setTitulo("Física 3");
		l2.setAnoPublicacao(2021);
		
		ArrayList<Livro> ls = new ArrayList<Livro>();
		ls.add(l1);
		ls.add(l2);
		
		Biblioteca b1 = new Biblioteca(ls);
		b1.setNome("Central");
		
		for (Livro livro : b1.getLivros()) {
			System.out.println(livro.getTitulo());
		}
	}
}
