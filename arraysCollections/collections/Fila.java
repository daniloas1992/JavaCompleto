package arraysCollections.collections;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {
    
    public static void main(String[] args) {
    
        Queue<String> fila = new LinkedList<>();

        // É possível configurar o tamanho máxima da fila

        fila.add("Ada"); // Lança exceção se a fila já estiver com capacidade máxima
        fila.add("Bruno");
        fila.add("Caio");

        fila.offer("Pedro"); // Retorna false se a fila já estiver com capacidade máxima

        System.out.println(fila.peek()); // Retorna o primeiro elemento da fila, porém não remove. Se a fila estiver vazia retorna null
        
        System.out.println(fila.element()); // Retorna o primeiro elemento da fila, porém não remove. Se a fila estiver vazia lança exceção

        System.out.println(fila.poll()); // Retorna o primeiro elemento da fila, e remove. Se a fila estiver vazia retorna null

        System.out.println(fila.remove()); // Retorna o primeiro elemento da fila, e remove. Se a fila estiver vazia lança exceção

        fila.clear();

        fila.isEmpty();

    }

}
