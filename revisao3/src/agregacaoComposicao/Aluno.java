package agregacaoComposicao;

public class Aluno extends Pessoa{
	
	private String curso;
	
	@Override
	public String obterInformacoes() {

		return super.obterInformacoes() + " - Curso: " + this.getCurso();
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
