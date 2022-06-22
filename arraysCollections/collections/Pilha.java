package arraysCollections.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha {

    public static void main(String[] args) {
        
        Deque<String> livros = new ArrayDeque<>();

        livros.add("Livro 1"); // Retorna boolean
        livros.add("Livro 2");

        livros.push("Livro 3"); // Se não conseguir inserir lança exceção
        livros.push("Livro 4");

        System.out.println(livros.peek()); // Retorna o primeiro elemento da fila, porém não remove. Se a fila estiver vazia retorna null
        
        System.out.println(livros.element()); // Retorna o primeiro elemento da fila, porém não remove. Se a fila estiver vazia lança exceção

        System.out.println(livros.poll()); // Retorna o primeiro elemento da fila, e remove. Se a fila estiver vazia retorna null

        System.out.println(livros.remove()); // Retorna o primeiro elemento da fila, e remove. Se a fila estiver vazia lança exceção

        livros.clear();

        livros.isEmpty();

    }
    
}
