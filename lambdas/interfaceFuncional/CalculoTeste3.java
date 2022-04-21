package lambdas.interfaceFuncional;

import java.util.function.BinaryOperator;

public class CalculoTeste3 {

	public static void main(String[] args) {

		/* Interface Funcional BinaryOperator */
		BinaryOperator<Double> calculo = (x,y) -> {return x+y; };	
		System.out.println(calculo.apply(2.0,5.0));

		calculo = (x,y) -> {return x*y; };
		System.out.println(calculo.apply(2.0,5.0));

	}
}
