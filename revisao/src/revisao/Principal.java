package revisao;

public class Principal {
	public static void main(String[] args) {
		
		Livro l1 = new Fisico();
		l1.setTitulo("Algebra");
		l1.setAutor("Stewart");
		l1.imprimeInformacoes();// Classe diferentes mesmo método == sobrescrita
		
		Biblioteca b1 = new Biblioteca("Central");
		System.out.println(b1.getNome());
		b1.setLivro(l1);
	}
}
