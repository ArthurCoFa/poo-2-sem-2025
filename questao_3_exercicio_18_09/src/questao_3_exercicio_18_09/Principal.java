package questao_3_exercicio_18_09;

public class Principal {
	
	public static void main(String[] args) {
		
		Universidade u1 = new Universidade();
		u1.setEndereco("706 norte");
		u1.setNomeUniversidade("Uniceub");
		
		Professor p1 = new Professor();
		p1.setCpf("1290");
		p1.setNomeProfessor("Carlos");
		
		Departamento d1 = new Departamento(u1);
		
		d1.setNomeDepartamento("Fisica");
		
		System.out.println(d1.getUniversidade().getEndereco() +
				           " - " + 
						   d1.getNomeDepartamento() + 
						   " - " +
						   d1.getUniversidade().getNomeUniversidade() +
						   " - " +
						   p1.getCpf() +
						   " - " +
						   p1.getNomeProfessor());
	}
}
