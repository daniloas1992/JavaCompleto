package lambdas.interfaceFuncional;

/*
Iterfaces funcionais devem conter apenas 1 método abstrato
*/

@FunctionalInterface
public interface Calculo2 {

	//Apenas 1 método abstrato:
	double executar (double a, double b);

	//Pode existir um método default
	default String legal() {
		//Da pra usar o método abstrato
		return "legal";
	}

	//Podem existir métodos estáticos
	static String muitoLegal() {
		return "Muito Legal";
	}

	static String muitoLegalDois() {
		return "Muito Legal Dois";
	}

}
