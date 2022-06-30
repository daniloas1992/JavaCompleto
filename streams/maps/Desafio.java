package streams.maps;

import java.util.Arrays;
import java.util.List;

public class Desafio {
  public static void main(String[] args) {
    
    List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);

    /* 
     * 1. Número para string binária...6 => "110"
     * 2. Inverter a string... "110" => "011"
     * 3. Converter de volta para inteiro "011" => 3
    */

    nums.stream() // 1 2 3 4 5 6 7 8 9
        .map(Utilitarios.converterBinario) // 1 10 11 100 101 110 111 1000 1001 
        //.map(Integer::toBinaryString)
        .map(Utilitarios.inverter) // 1 01 11 001 101 011 111 0001 1001
        .map(Utilitarios.converterNumero) // 1 1 3 1 5 3 7 1 9
        .forEach(System.out::println);
    
  }
}
