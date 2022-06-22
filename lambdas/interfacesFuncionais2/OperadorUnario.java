package lambdas.interfacesFuncionais2;

import java.util.function.UnaryOperator;

public class OperadorUnario {

    public static void main(String[] args) {
        
        UnaryOperator<Integer> maisDois = valor -> valor + 2;

        UnaryOperator<Integer> vezesDois = valor -> valor * 2;

        UnaryOperator<Integer> aoQuadrado = valor -> valor * valor;

        int resultado1 = maisDois
            .andThen(vezesDois)
            .andThen(aoQuadrado)
            .apply(0);
        
        System.out.println(resultado1);

        //Compose faz a próxima chamada ser executada antes, portanto executado do fim para o começo
        int resultado2 = maisDois
            .compose(vezesDois)
            .compose(aoQuadrado)
            .apply(0);
        
        System.out.println(resultado2);


    }
    
}
