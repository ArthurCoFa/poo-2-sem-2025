package aula_25_09;

public class Principal {
	
	public static void main(String[] args) { // Exemplo de agregação
		
		Livro l1 = new Livro();
		l1.setAutor("Felipe");
		l1.setTitulo("Cálculo II");
		l1.setAnoPublicacao(2020);
		
		Livro l2 = new Livro();
		l2.setAutor("Carlos");
		l2.setTitulo("Física 3");
		l2.setAnoPublicacao(2021);
		
		Biblioteca b1 = new Biblioteca();
		b1.setNome("Central");
		b1.getLivros().add(l1);
		b1.getLivros().add(l2);
		
		for (Livro livro : b1.getLivros()) {
			System.out.println(livro.getTitulo());
		}
	}
}
