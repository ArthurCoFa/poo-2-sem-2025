package questao8;

class Animal {
	String nome;
	
	public Animal(String nome) {
		this.nome = nome;
	}
	
	public void fazerSom() {
		System.out.println("Som generico");
	}
	
}

class Cachorro extends Animal {
}

public class TesteAnimais{
	public static void main(String[] args) {
		Animal meuAnimal = new Animal("Generico");
		Cachorro meuCachorro = new Cachorro("rex");
		
		meuAnimal.fazerSom();
		meuCachorro.fazerSom();
	}
}
