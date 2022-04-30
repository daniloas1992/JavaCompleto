package streams.filters;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;

public class Desafio1 {

  public static void main(String[] args) {
    
    Produto p1 = new Produto("TV", 450.00, 0, true, false);
    Produto p2 = new Produto("Rádio", 50.00, 0, false, false);
    Produto p3 = new Produto("Sofá", 365.00, 0, true, false);
    Produto p4 = new Produto("Mesa", 745.00, 0, false, false);
    Produto p5 = new Produto("Telefone", 850.00, 0, false, false);

    List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5);

    Predicate<Produto> produtosCaros = p -> p.valor >= 400.00;
    Predicate<Produto> produtosComImposto = p -> p.temImposto;
    Function<Produto, String> produtoCaroComImposto = a -> "O produto " + a.descricao + " está caro e tem Imposto!";

    produtos.stream()
            .filter(produtosCaros)
            .filter(produtosComImposto)
            .map(produtoCaroComImposto)
            .forEach(System.out::println);
  }
}
