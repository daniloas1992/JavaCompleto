package lambdas.interfacePadrao;

public class CalculoTeste {

	public static void main(String[] args) {

		Calculo calculo = (x,y) -> {return x+y; };
		
		System.out.println(calculo.executar(2,5));
	}

}
