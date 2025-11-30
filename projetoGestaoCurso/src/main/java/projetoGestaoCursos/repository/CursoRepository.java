package projetoGestaoCursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetoGestaoCursos.model.Curso;

//Interface para utilizar métodos CRUD
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
