package questao8;

public class Questao10 {
	class Animal {
		public String nome;
		
		public Animal(String nome) {
			this.nome = nome;
		}
		
		public void fazerSom() {
			System.out.println("Som generico");
		}
		
	}

	class Cachorro extends Animal {
		public Cachorro(String nome) {
			this.nome = nome;
		}
		
		public void latir() {
			System.out.println("au");
		}
	}

	public class TesteAnimais{
		public static void main(String[] args) {
			Animal meuAnimal = new Animal("Generico");
			Cachorro meuCachorro = new Cachorro("rex");
			
			meuAnimal.fazerSom();
			meuCachorro.fazerSom();
		}
	}
}
