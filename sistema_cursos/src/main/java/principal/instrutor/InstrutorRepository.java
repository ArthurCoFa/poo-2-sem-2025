package principal.instrutor;

import org.springframework.data.jpa.repository.JpaRepository;

// Interface para utilizar métodos CRUD
public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
	
	boolean existsByCpf(String cpf); // Usado para verificar se cpf já existe em Aluno ou Instrutor
}
