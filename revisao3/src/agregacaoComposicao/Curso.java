package agregacaoComposicao;

import java.util.ArrayList;

public class Curso {
	
	private String nomeCurso;
	private ArrayList<Modulo> modulos = new ArrayList<Modulo>();
	
	public void adicionarModulo(String titulo, int cargaHoraria) {
		
		this.modulos.add(new Modulo(titulo, cargaHoraria));
	}
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public ArrayList<Modulo> getModulos() {
		return modulos;
	}
	public void setModulos(ArrayList<Modulo> modulos) {
		this.modulos = modulos;
	}
}
