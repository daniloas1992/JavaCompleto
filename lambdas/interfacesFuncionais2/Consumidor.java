package lambdas.interfacesFuncionais2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumidor {

    public static void main(String[] args) {
        
        Consumer<Produto> imprimir = prod -> System.out.println(prod.nome);

        Produto p1 = new Produto("Caneta", 1.00, 0.10);
        imprimir.accept(p1);


        Produto p2 = new Produto("Caderno", 10.00, 0.05);
        Produto p3 = new Produto("Borracha", 2.00, 0.08);
        Produto p4 = new Produto("Lápis", 1.80, 0.07);

        List<Produto> produtos = Arrays.asList(p1, p2, p3, p4);

        produtos.forEach(imprimir);

        produtos.forEach(p -> System.out.println(p.preco));

        produtos.forEach(System.out::println);

    }
    
}
