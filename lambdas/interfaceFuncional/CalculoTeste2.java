package lambdas.interfaceFuncional;

public class CalculoTeste2 {

	public static void main(String[] args) {

		Calculo2 calculo = (x,y) -> {return x+y; };
		
		System.out.println(calculo.executar(2,5));
		System.out.println(calculo.legal());
		System.out.println(Calculo2.muitoLegal());
	}

}
