package principal.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import principal.classes.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
