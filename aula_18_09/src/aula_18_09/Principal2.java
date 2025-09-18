package aula_18_09;

public class Principal2 {
	
	public static void main(String[] args) {
		
		Endereco end2 = new Endereco();
		
		end2.setCep("129803");
		end2.setLogradouro("Quadra 3");
		end2.setNumero(5);
		
		String nome = "Pedro";
		
		Aluno a2 = new Aluno(nome, end2);
		
		System.out.println(a2.getNome() +
				           " - " +
				           a2.getEndereco().getLogradouro() +
				           " - " +
				           a2.getRa());
	}
}
