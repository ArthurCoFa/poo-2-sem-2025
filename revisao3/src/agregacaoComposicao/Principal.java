package agregacaoComposicao;

public class Principal {
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno();
		a1.setCurso("Geografia");
		a1.setId(22);
		a1.setNome("Felipe");
		
		Professor p1 = new Professor();
		p1.setId(10);
		p1.setNome("joão");
		p1.setDisciplina("Matemática");
		
		Departamento d1 = new Departamento();
		
		d1.adicionarProfessor(p1);
		d1.adicionarAluno(a1);
		
		Curso c1 = new Curso();
		c1.setNomeCurso("Geografia");
		c1.adicionarModulo("Analise do espaço natural", 100);
		
		for(int i = 0; i < c1.getModulos().size(); i++) {
			
			System.out.println(c1.getModulos().get(i));
		}
		
//		for(Modulo elemento : c1.getModulos()) {
//			
//		    System.out.println(elemento); 
//		}
		
		d1.listarMembros();
	}
}
