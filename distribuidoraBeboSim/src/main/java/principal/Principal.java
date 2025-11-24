package principal;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import principal.respository.*;
import principal.classes.*;

@SpringBootApplication
public class Principal implements CommandLineRunner{
	
	@Autowired
	private CampanhaRepository campanhaRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(Principal.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Campanha c1 = new Campanha();
		LocalDate dtInicio = LocalDate.of(2007, 01, 22);
		LocalDate dtFim = LocalDate.of(2007, 01, 28);
		c1.setDtInicio(dtInicio);
		c1.setDtFim(dtFim);
		c1.setNome("Festa fim de Janeiro");
		
		campanhaRepository.save(c1);
	}
}
