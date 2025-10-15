package agregacaoComposicao;

public class Professor extends Pessoa{
	
	private String disciplina;
	
	@Override
	public String obterInformacoes() {

		return super.obterInformacoes() + " - Disciplina do professor: " + this.getDisciplina();
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
}
