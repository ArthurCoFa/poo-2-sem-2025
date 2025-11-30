package projetoGestaoCursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetoGestaoCursos.model.Aluno;

//Interface para utilizar métodos CRUD
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	boolean existsByCpf(String cpf); 
	// Usado para verificar se cpf já existe em Aluno ou Instrutor
}
