package streams.maps;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Utilitarios {
  
  public final static UnaryOperator<String> maiuscula = m -> m.toUpperCase();
  public final static UnaryOperator<String> primeiraLetra = p -> p.charAt(0) + "";
  public final static UnaryOperator<String> exclamacao = e -> e + "!!!";

  public final static Function<Integer, String> converterBinario = n -> n.toBinaryString(n);
  public final static UnaryOperator<String> inverter = i -> new StringBuilder(i).reverse().toString();
  //public final static Function<String, String> converterNumero = i -> String.valueOf(Integer.parseInt(i, 2)) + " ";
  public final static Function<String, Integer> converterNumero = i -> Integer.parseInt(i, 2);

}
