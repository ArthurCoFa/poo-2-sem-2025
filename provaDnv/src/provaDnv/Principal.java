package provaDnv;

public class Principal {
	public static void main(String[] args) {
		Paciente paciente1 = new Paciente();
		paciente1.setCpf("213");
		paciente1.setNome("Arthur");
		paciente1.setDataNascimento(2000);
		paciente1.setConvenio("quality");
		paciente1.setIdPaciente(1);
		
		Profissional profissional1 = new Profissional();
		profissional1.setEspecialidade("cardiologista");
		profissional1.setCpf("12451");
		profissional1.setDataNascimento(1986);
		profissional1.setIdProfissional(1);
		profissional1.setNome("Carlos");
		profissional1.setRegistroConselho("1287");
		
		Tratamento tratamento1 = new Tratamento(paciente1, profissional1);
		tratamento1.setMesInicio(2);
		tratamento1.setIdTratamento(1);
		tratamento1.setStatus("Risco");
		
		paciente1.calcularIdade();
	}
}
