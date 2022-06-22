package lambdas.interfacesFuncionais2;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class OperadorBinario {
    
    public static void main(String[] args) {
        
        BinaryOperator<Double> media = (Double n1, Double n2) -> (n1 + n2) / 2;

        BiFunction<Double, Double, String> resultado = (n1, n2) -> ((n1 + n2) / 2 ) >= 7.0 ? "Aprovado" : "Reprovado";

        Function<Double, String> conceito = valor -> valor >= 7.0 ?  "Aprovado" : "Reprovado";

        System.out.println(media.apply(9.8, 5.7));
        
        System.out.println(resultado.apply(9.8, 5.7));

        System.out.println(media.andThen(conceito).apply(9.8, 5.7));


    }

}
