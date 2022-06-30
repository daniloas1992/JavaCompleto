package lambdas.desafio;

import java.text.DecimalFormat;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import lambdas.interfacesFuncionais2.Produto;

public class Desafio {

    public static void main(String[] args) {
        
        Produto p = new Produto("iPad", 3235.89, 0.13);

        Function<Produto, Double> valorDesconto = produto -> produto.preco * (1 - produto.desconto);

        UnaryOperator<Double> imposto = valor -> valor >= 2500 ? valor * 1.085 : valor;

        UnaryOperator<Double> frete = valor -> valor + (valor >= 3000 ? 100.0 : 50.0);

        Function<Double, String> arredondar = valor -> new DecimalFormat("0.00").format(valor);

        UnaryOperator<String> moeda = valor -> "R$ "+ valor;

        String precoFinal = valorDesconto
        .andThen(imposto)
        .andThen(frete)
        .andThen(arredondar)
        .andThen(moeda)
        .apply(p);

        System.out.println(precoFinal);

    }
    
}
