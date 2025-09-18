package questao_4_exercicio_18_09;

public class Pedido {
	
	private int numeroPedido;
	private ItemPedido itemPedido;
	private Produto produto;

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public ItemPedido getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(ItemPedido itemPedido) {
		this.itemPedido = itemPedido;
	}
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	
}
