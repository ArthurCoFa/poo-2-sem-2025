package questao_4_exercicio_18_09;

public class ItemPedido {
	
	private Produto produto;
	private int quantidade;
	private Pedido pedido;
	
	public ItemPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public double getSubtotal() {
		
		double subtotal = 0;
		
		subtotal = quantidade * produto.getPreco();
		
		return subtotal;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
