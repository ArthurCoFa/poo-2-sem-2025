package questao_4_exercicio_18_09;

public class Principal {
	
	public static void main(String[] args) {
		
		Produto pro1 = new Produto();
		pro1.setNome("Banana");
		pro1.setPreco(7.9);
		
		Produto pro2 = new Produto();
		pro2.setNome("Maca");
		pro2.setPreco(10);
		
		Pedido ped1 = new Pedido();
		
		ped1.setNumeroPedido(1);
		ped1.setProduto(pro1);
		
		ItemPedido i1 = new ItemPedido(ped1);
		i1.setQuantidade(3);
		i1.setPedido(ped1);
		i1.setProduto(pro1);
		
		System.out.println(ped1.getItemPedido().getSubtotal());
		
	}
}
