package exercicio_11_09;

import java.util.ArrayList;

public class Questao_7 {
	
	public static void ordenador(ArrayList<Pessoa> a) {
		
		for(int j = 0; j < a.size(); j++) {
			
			for(int i = 0; i < a.size() - 1; i++) {
				
				int b = 0;
				String c = "";
				
				if(a.get(i).getIdade() > a.get(i + 1).getIdade()) {
					
					b = a.get(i).getIdade();
					c = a.get(i).getNome();
					
					a.get(i).setIdade(a.get(i + 1).getIdade());
					a.get(i).setNome(a.get(i + 1).getNome());
					
					a.get(i + 1).setIdade(b);
					a.get(i + 1).setNome(c);
				}
			}
		}
	}
	
	public static class Pessoa {
		
		private String nome;
		private int idade;
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public int getIdade() {
			return idade;
		}
		public void setIdade(int idade) {
			this.idade = idade;
		}
		
	}
	
	public static void main(String[] args) {
		
		ArrayList<Questao_7.Pessoa> lista = new ArrayList<Questao_7.Pessoa>();
		
		Questao_7.Pessoa p1 = new Questao_7.Pessoa();
		p1.setIdade(18);
		p1.setNome("Arthur");
		
		lista.add(p1);
		
		Questao_7.Pessoa p2 = new Questao_7.Pessoa();
		
		p2.setIdade(11);
		p2.setNome("Joao");
		
		lista.add(p2);
		
		Questao_7.Pessoa p3 = new Questao_7.Pessoa();
		
		p3.setIdade(9);
		p3.setNome("Carlos");
		
		lista.add(p3);
		
		Questao_7.Pessoa p4 = new Questao_7.Pessoa();
		
		p4.setIdade(10);
		p4.setNome("jose");
		
		lista.add(p4);
		
		System.out.println(lista.get(0).getIdade());
		System.out.println(lista.get(0).getNome());
		
		System.out.println(lista.get(1).getIdade());
		System.out.println(lista.get(1).getNome());
		
		System.out.println(lista.get(2).getIdade());
		System.out.println(lista.get(2).getNome());
		
		System.out.println(lista.get(3).getIdade());
		System.out.println(lista.get(3).getNome());
		
		ordenador(lista);
		
		System.out.println("\n\n");
		
		System.out.println(lista.get(0).getIdade());
		System.out.println(lista.get(0).getNome());
		
		System.out.println(lista.get(1).getIdade());
		System.out.println(lista.get(1).getNome());
		
		System.out.println(lista.get(2).getIdade());
		System.out.println(lista.get(2).getNome());
		
		System.out.println(lista.get(3).getIdade());
		System.out.println(lista.get(3).getNome());
		
	}
	
}
