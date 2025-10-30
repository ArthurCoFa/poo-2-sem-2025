package questao4;

public class Automovel {
	
	public void ligarMotor() {
		
		System.out.println("Motor ligado");
	}
	public void ligarMotor(boolean usouAfogador) {
		
		if(usouAfogador) {
			
			System.out.println("Automovel ligado!");
		} else {
			
			System.out.println("Automovel Afogado!");
		}
	}
}
