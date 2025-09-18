package questao_2_exercicio_18_09;

public class Computador {
	
	private Processador processador;
	private MemoriaRam memoriaRam;
	
	public Computador(Processador processador, MemoriaRam memoriaRam) {
		this.processador = processador;
		this.memoriaRam = memoriaRam;
	}
	
	public Processador getProcessador() {
		return processador;
	}
	public void setProcessador(Processador processador) {
		this.processador = processador;
	}
	public MemoriaRam getMemoriaRam() {
		return memoriaRam;
	}
	public void setMemoriaRam(MemoriaRam memoriaRam) {
		this.memoriaRam = memoriaRam;
	}
	
	public void exibirDetalhes() {
		System.out.println(getMemoriaRam().getCapacidade() +
				           " - " +
				           getMemoriaRam().getTipo() +
				           " - " +
				           getProcessador().getFrequencia() +
				           " - " +
				           getProcessador().getMarca());
	}
}
