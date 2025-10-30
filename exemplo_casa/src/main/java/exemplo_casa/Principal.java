package exemplo_casa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Principal implements CommandLineRunner {
	
	@Autowired
	AlunosRepository alunosRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Principal.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Alunos a = new Alunos();
		a.setId(2L);
		a.setIdade(22);
		a.setNome("João");
		
		alunosRepository.save(a);

	}
}
