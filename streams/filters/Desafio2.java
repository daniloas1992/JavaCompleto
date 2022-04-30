package streams.filters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;

public class Desafio2 {

  public static void main(String[] args) {
    
    Produto p1 = new Produto("TV", 450.00, 35, true, false);
    Produto p2 = new Produto("Rádio", 50.00, 10, false, true);
    Produto p3 = new Produto("Sofá", 365.00, 25, true, false);
    Produto p4 = new Produto("Mesa", 745.00, 30, false, true);
    Produto p5 = new Produto("Telefone", 850.00, 31, true, false);

    List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5);

    Predicate<Produto> produtosDesconto = p -> p.desconto >= 30.00;
    Predicate<Produto> produtosSemFrete = p -> !(p.temFrete);
    Function<Produto, String> produtoSuperPromocao = a -> "O produto " + a.descricao + " está com promoção!";

    produtos.stream()
            .filter(produtosDesconto)
            .filter(produtosSemFrete)
            .map(produtoSuperPromocao)
            .forEach(System.out::println);

  }

}
