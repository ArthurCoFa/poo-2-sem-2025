package projetoGestaoCursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetoGestaoCursos.model.Instrutor;

//Interface para utilizar métodos CRUD
public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {

	boolean existsByCpf(String cpf); 
	// Usado para verificar se cpf já existe em Aluno ou Instrutor
}
