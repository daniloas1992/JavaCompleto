package streams.introducao;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CriandoStreams {

  public static void main(String[] args) {
    
    Consumer<String> print = System.out::print;
    Consumer<Integer> printl = System.out::println;

    Stream<String> langs = Stream.of("Java ", "Lua ", "JS\n");
    langs.forEach(print);

    String[] maisLangs = {"Python ", "Lisp ", "Pearl ", "Go\n"};
    Stream.of(maisLangs).forEach(print);

    Arrays.stream(maisLangs).forEach(print);
    System.out.println("De 0 a 4: ");
    Arrays.stream(maisLangs, 0, 4).forEach(print);
    System.out.println("\nDe 1 a 3: ");
    Arrays.stream(maisLangs, 1, 3).forEach(print);
    System.out.println("\nDe 1 a 4: ");
    Arrays.stream(maisLangs, 1, 4).forEach(print);

    List<String> outrasLangs = Arrays.asList("C ", "PHP ", "Kotlin\n");
    outrasLangs.stream().forEach(print);
    outrasLangs.parallelStream().forEach(print);

    //Stream.generate(() -> "a").forEach(print); // Fica gerando "a" 
    //Stream.iterate(0, n -> n + 1).forEach(printl); // Gera inteiros de forma incremental a partir de 0

  }
  
}
