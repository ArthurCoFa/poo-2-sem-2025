package principal.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import principal.classes.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>{

}
