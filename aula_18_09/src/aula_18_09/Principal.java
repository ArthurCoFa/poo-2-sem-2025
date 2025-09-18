package aula_18_09;

public class Principal { // Agregação
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno();
		
		a1.setNome("José");
		a1.setRa("1202");
		
		Endereco e1 = new Endereco();
		e1.setCep("91200");
		e1.setLogradouro("Quadra 1");
		e1.setNumero(7);
		
		Email c1 = new Email();
		c1.setNome("arthur.farias");
		c1.setTipo("@sempreceub.com");
		
		a1.setEndereco(e1);
		a1.setEmail(c1);
		
		System.out.println(a1.getNome() +
						   " - " +
				           a1.getRa() +
				           " - " +
						   a1.getEndereco().getLogradouro() +
						   " - " +
						   a1.getEmail().getNome() +
						   " - " +
						   a1.getEmail().getTipo());	
	}
}
