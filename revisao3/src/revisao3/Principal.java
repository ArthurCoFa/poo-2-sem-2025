package revisao3;

import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) {
		
		Gerente g1 = new Gerente();
		g1.setBonusAnual(1000);
		g1.setCpf("67940209-11");
		g1.setNome("João Felipe");
		g1.setSalarioBase(3500);
		
		Desenvolvedor d1 = new Desenvolvedor();
		d1.setCpf("192840291-10");
		d1.setNome("Arthur");
		d1.setProjetosConcluidos(10);
		d1.setSalarioBase(4000);
		
		Estagiario e1 = new Estagiario();
		e1.setAuxilioTransporte(400);
		e1.setCpf("904892019-01");
		e1.setNome("Carlos");
		e1.setSalarioBase(1500);
		
		ArrayList<Funcionario> time = new ArrayList<Funcionario>();
		time.add(g1);
		time.add(d1);
		time.add(e1);
		
		for(Funcionario elemento : time) {
			FolhaPagamento.processar(elemento);
		}
	}
}
