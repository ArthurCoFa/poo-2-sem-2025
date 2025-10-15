package agregacaoComposicao;

public class Modulo {
	
	private String titulo;
	private int cargaHoraria;
	
	public Modulo(String titulo, int cargaHoraria) {
		this.titulo = titulo;
		this.cargaHoraria = cargaHoraria;
	}
	
	@Override
	public String toString() {
		
		return titulo + " - " + cargaHoraria + "h";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
}
