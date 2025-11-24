package principal.classes;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ProdutoCampanha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private BigDecimal precoCampanha;
	
	private String GarotoPropaganda;
	
	@ManyToOne
	private Produto produtos;
	
	@ManyToOne
	private Campanha campanhas;

	public Produto getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}

	public Campanha getCampanhas() {
		return campanhas;
	}

	public void setCampanhas(Campanha campanhas) {
		this.campanhas = campanhas;
	}

	public BigDecimal getPrecoCampanha() {
		return precoCampanha;
	}

	public void setPrecoCampanha(BigDecimal precoCampanha) {
		this.precoCampanha = precoCampanha;
	}

	public String getGarotoPropaganda() {
		return GarotoPropaganda;
	}

	public void setGarotoPropaganda(String garotoPropaganda) {
		GarotoPropaganda = garotoPropaganda;
	}
}
