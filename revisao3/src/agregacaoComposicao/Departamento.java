package agregacaoComposicao;

import java.util.ArrayList;

public class Departamento {
	
	private String nomeDepartamento;
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	public void adicionarProfessor(Professor p1) {
		
		this.professores.add(p1);
	}
	
	public void adicionarAluno(Aluno a1) {
		
		this.alunos.add(a1);
	}
	
	public void listarMembros() {
		
		System.out.println("Professores");
		
		for(int i = 0; i < professores.size(); i++) {
			
			System.out.println(professores.get(i).obterInformacoes());
		}
		
		System.out.println("Alunos");
		
		for(int i = 0; i < alunos.size(); i++) {
		
			System.out.println(alunos.get(i).obterInformacoes());
		}
		
//		for(Aluno elemento : alunos) {
//		
//			System.out.println(elemento.obterInformacoes());
//		}
		
//		for(Professor elemento : professores) {
//			
//			System.out.println(elemento.obterInformacoes());
//		}
	}

	public ArrayList<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(ArrayList<Professor> professores) {
		this.professores = professores;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}
}
