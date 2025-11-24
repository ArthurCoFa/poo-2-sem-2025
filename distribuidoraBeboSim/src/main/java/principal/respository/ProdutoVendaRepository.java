package principal.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import principal.classes.ProdutoVenda;

public interface ProdutoVendaRepository extends JpaRepository<ProdutoVenda, Long>{

}
