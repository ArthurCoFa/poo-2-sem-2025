package questao_1_exercicio_18_09;

public class Principal {
	
	public static void main(String[] args) {
		
		Biblioteca b1 = new Biblioteca();
		b1.setNome("Biblioteca Central");
		
		Livro l1 = new Livro();
		l1.setAnoPublicacao(2020);
		l1.setAutor("Felipe da Silva");
		l1.setTitulo("Desligado da vida");
		
		b1.setLivro(l1);
		
		System.out.println(b1.getNome() +
				           " - " +
				           b1.getLivro().getTitulo()+
				           " - " +
				           b1.getLivro().getAnoPublicacao());
	}
}
