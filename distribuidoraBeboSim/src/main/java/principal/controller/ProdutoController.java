package principal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import principal.classes.Embalagem;
import principal.classes.Fabrica;
import principal.classes.Produto;
import principal.respository.EmbalagemRepository;
import principal.respository.FabricaRepository;
import principal.respository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private FabricaRepository fabricaRepository;
	@Autowired
	private EmbalagemRepository embalagemRepository;
	
	@GetMapping
	public List<Produto> listarProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> buscarProdutoId(@PathVariable Long id){
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		
		if(optionalProduto.isPresent()) return optionalProduto;
		
		return null;
	}
	
	@PostMapping
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PutMapping("/{idProduto}")
	public Produto atualizarProduto(@PathVariable Long idProduto, @RequestBody Produto novoProduto) {
		
		Optional<Produto> optionalProduto = produtoRepository.findById(idProduto);
		
		if(optionalProduto.isPresent()) {
			
			Produto produto = optionalProduto.get();
			produto.setComissao(novoProduto.getComissao());
			produto.setNome(novoProduto.getNome());
			produto.setQuantidade(novoProduto.getQuantidade());
			produto.setValor(novoProduto.getValor());
			
			return produtoRepository.save(produto);

		}
		return null;
	}
	
	@PostMapping("/{idProduto}/fabrica/{idFabrica}")
	public Produto adicionarFabrica(@PathVariable Long idProduto, @PathVariable Long idFabrica) {
		
		Optional<Produto> optionalProduto = produtoRepository.findById(idProduto);
		
		Optional<Fabrica> optionalFabrica = fabricaRepository.findById(idFabrica);
		
		if(optionalFabrica.isPresent() && optionalProduto.isPresent()) {
			Produto produto = optionalProduto.get();
			Fabrica fabrica = optionalFabrica.get();
			produto.getFabricas().add(fabrica);
			
			return produtoRepository.save(produto);
		}
		return null;
	}
	
	@PostMapping("/{idProduto}/embalagem/{idEmbalagem}")
	public Produto adicionarEmbalagem(@PathVariable Long idProduto, @PathVariable Long idEmbalagem) {
		
		Optional<Produto> optionalProduto = produtoRepository.findById(idProduto);
		
		Optional<Embalagem> optionalEmbalagem = embalagemRepository.findById(idEmbalagem);
		
		if(optionalEmbalagem.isPresent() && optionalProduto.isPresent()) {
			Produto produto = optionalProduto.get();
			Embalagem embalagem = optionalEmbalagem.get();
			produto.getEmbalagens().add(embalagem);
			
			return produtoRepository.save(produto);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public void deletarProduto(@PathVariable Long id) {
		produtoRepository.deleteById(id);
	}
	
	@DeleteMapping("/{idProduto}/fabrica/{idFabrica}")
	public Produto deletarFabricaProduto(@PathVariable Long idProduto, @PathVariable Long idFabrica) {
		
		Optional<Produto> optionalProduto = produtoRepository.findById(idProduto);
		
		Optional<Fabrica> opionalFabrica = fabricaRepository.findById(idFabrica);
		
		if(opionalFabrica.isPresent() && optionalProduto.isPresent()) {
			Fabrica fabrica = opionalFabrica.get();
			
			Produto produto = optionalProduto.get();
			
			produto.getFabricas().remove(fabrica);
			
			return produtoRepository.save(produto);
		}
		return null;
	}
	
	@DeleteMapping("/{idProduto}/embalagem/{idEmbalagem}")
	public Produto deletarEmbalagemProduto(@PathVariable Long idProduto, @PathVariable Long idEmbalagem) {
		
		Optional<Produto> optionalProduto = produtoRepository.findById(idProduto);
		
		Optional<Embalagem> optionalEmbalagem = embalagemRepository.findById(idEmbalagem);
		
		if(optionalProduto.isPresent() && optionalEmbalagem.isPresent()) {
			Embalagem embalagem = optionalEmbalagem.get();
			
			Produto produto = optionalProduto.get();
			
			produto.getEmbalagens().remove(embalagem);
			
			return produtoRepository.save(produto);
		}
		return null;
	}
}
