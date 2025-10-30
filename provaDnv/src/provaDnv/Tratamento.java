package provaDnv;

public class Tratamento {
	private int idTratamento;
	private int mesInicio;
	private String status;
	
	public void finalizarTratamento() {
		
	}
	public Tratamento(Paciente paciente, Profissional profissional) {
		
	}
	
	public int getIdTratamento() {
		return idTratamento;
	}
	public void setIdTratamento(int idTratamento) {
		this.idTratamento = idTratamento;
	}
	public int getMesInicio() {
		return mesInicio;
	}
	public void setMesInicio(int mesInicio) {
		this.mesInicio = mesInicio;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
