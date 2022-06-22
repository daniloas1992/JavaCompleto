package lambdas.interfacesFuncionais2;

import java.util.function.Function;

public class Funcao {

    public static void main(String[] args) {
          
        Function<Integer, String> parOuImpar = numero -> numero % 2 == 0 ? "Par" : "Ímpar";

        Function<String, String> oResultadoEh = valor -> "O resultado é: " + valor;

        Function<String, String> empolgado = valor -> valor + "!!!";

        Function<String, String> duvida = valor -> valor + "???";

        System.out.println(parOuImpar.andThen(oResultadoEh).andThen(empolgado).apply(32));

        System.out.println(parOuImpar.andThen(oResultadoEh).andThen(duvida).apply(33));

    }
    
}