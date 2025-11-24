package principal.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import principal.classes.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
