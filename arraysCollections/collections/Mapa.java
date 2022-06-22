package arraysCollections.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Mapa {

    public static void main(String[] args) {
        
        Map<Integer, String> usuarios = new HashMap<>();

        usuarios.put(1, "Carlos"); // Adiciona se não existir a chave
        usuarios.put(1, "Pedro");  // Altera se já existir a chave

        usuarios.put(2, "Ricardo");
        usuarios.put(3, "Maria");
        usuarios.put(4, "Rodrigo");

        System.out.println(usuarios.size());

        System.out.println(usuarios.isEmpty());

        System.out.println(usuarios.keySet()); // Retorna um array com as chaves

        System.out.println(usuarios.values()); // Retorna um array com os valores

        System.out.println(usuarios.entrySet()); // Retorna um array com as chaves e valores

        System.out.println(usuarios.containsKey(1)); // Verifica se a chave existe

        System.out.println(usuarios.containsValue("Pedro")); // Verifica se o valor existe

        System.out.println(usuarios.get(2)); // Obter o valor a partir da chave

        System.out.println(usuarios.remove(3)); // Remove a patir do valor da chave

        System.out.println(usuarios.remove(4, "Rodrigo")); // Remove a patir da chave e do valor, os dois precisam dar verdadeiro

        for(int chave : usuarios.keySet()) {
            System.out.println(chave);
        }

        for(String valor: usuarios.values()) {
            System.out.println(valor);
        }

        for(Entry<Integer, String> usuario: usuarios.entrySet()) {
            System.out.println(usuario.getKey());
            System.out.println(usuario.getValue());
        }
    }
    
}
