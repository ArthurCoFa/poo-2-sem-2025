package questao8;

public class Questao9 {
	
	class Forma {
		
		public double CalcularArea() {
			
			return 0.0;
		}
	}
	
	class Retangulo extends Forma {
		public double altura;
		public double largura;
		
		public Retangulo(double altura, double largura) {
			this.altura = altura;
			this.largura = largura;
		}
		
		@Override
		public double CalcularArea() {
			
			return largura * altura;
		}	
		
		public static void main(String[] args) {
			Forma minhaForma = new Forma();
			Forma meuRetangulo = new Retangulo(5, 10);
			
			System.out.println("Area generica" + minhaForma.CalcularArea());
			System.out.println("Area retangulo" + meuRetangulo.CalcularArea());
		}
	}
}
