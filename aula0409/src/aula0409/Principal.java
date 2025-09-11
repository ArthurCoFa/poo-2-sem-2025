package aula0409;

public class Principal {
	
	public static void main(String[] args) { // Main
		
		Carro c1 = new Carro(); // Criação de um novo objeto
		c1.setMarca("Fiat"); // Marca usando o extend do automovel em carro
		c1.setModelo("Pulse"); // Modelo usando o extend do automovel em carro
		c1.setAno(2026); // Ano usando o extend do automovel em carro
		c1.ligar(); // Método com parâmetro, que é diferente do método sem necessidade do parâmetro
		
		Carro c2 = new Carro();
		
		c2.setMarca("VW");
		c2.setModelo("Nivus");
		c2.setAno(2025);
		
		System.out.println(c1.getModelo());
		System.out.println(c2.getModelo());
	
	}
}
