package exemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Principal implements CommandLineRunner {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Principal.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Pessoa p = new Pessoa();
		p.setNome("Arthur da Costa");
		p.setIdade(18);
		
		pessoaRepository.save(p);
	}
}
