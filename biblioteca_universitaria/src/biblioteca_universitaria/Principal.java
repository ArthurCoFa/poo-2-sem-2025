package biblioteca_universitaria;

public class Principal {
	
	public static void main(String[] args) {

		Tese t1 = new Tese() ; 
		t1.ano = 2024;
		t1.autor = "Robinho";
		t1.curso = "computacao";
		t1.titulo = "tese legal";
		
		System.out.println(t1.ano + "\n" + t1.autor + "\n" + t1.curso + "\n" + t1.titulo);
	}
}
