package principal.classes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	private int quantidade;
	
	private BigDecimal comissao;
	
	@ManyToMany
	@JoinTable(
		name = "produto_embalagem",
		joinColumns = @JoinColumn(name = "produto_id"),
		inverseJoinColumns = @JoinColumn(name = "embalagem_id")
	)
	private List<Embalagem> embalagens = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(
		name = "produto_fabrica",
		joinColumns = @JoinColumn(name = "produto_id"),
		inverseJoinColumns = @JoinColumn(name = "fabrica_id")
	)
	private List<Fabrica> fabricas = new ArrayList<>();

	public List<Embalagem> getEmbalagens() {
		return embalagens;
	}

	public void setEmbalagens(List<Embalagem> embalagens) {
		this.embalagens = embalagens;
	}

	public List<Fabrica> getFabricas() {
		return fabricas;
	}

	public void setFabricas(List<Fabrica> fabricas) {
		this.fabricas = fabricas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}
}
