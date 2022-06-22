package arraysCollections.collections;

import java.util.ArrayList;

public class Listas {
    
    public static void main(String[] args) {
        
        ArrayList<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Pedro"));
        lista.add(new Usuario("Carlos"));
        lista.add(new Usuario("Eduardo"));
        lista.add(new Usuario("Maria"));
        lista.add(new Usuario("Helena"));

        System.out.println(lista.get(2)); // Obter valor a partir do índice

        lista.remove(1); // Remover a partir do índice, retorna o objeto removido

        // Como Usuário sobrescreveu o método equals para comparar apenas o nome, ao invés do endereço de memória,
        // vai conseguir identificar e remover
        lista.remove(new Usuario("Carlos")); // Retorna um boolean

        lista.contains(new Usuario("Pedro"));


    }
}
