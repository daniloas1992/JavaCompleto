package arraysCollections.collections;

import java.util.HashSet;
import java.util.Set;

public class SetHeterogeneo {

    public static void main(String[] args) {
        
        // O ideal é definir um tipo: HashSet<String>
        HashSet conjunto = new HashSet();

        // Faz conversão automática de tipos primitivos
        conjunto.add(1.2); // tranforma o double em Double
        conjunto.add(true); // transform ao boolean em Boolean
        conjunto.add("Teste");
        conjunto.add(1); // tranforma o int em Integer

        System.out.println(conjunto.size()); // tamanho 4

        conjunto.add("teste");
        System.out.println(conjunto.size()); // tamanho 5

        conjunto.add("Teste");
        System.out.println(conjunto.size()); // tamanho 5, pois não aceita elementos repetidos

        System.out.println(conjunto.remove(1)); // Retorna true/false

        System.out.println(conjunto.contains("teste"));

        Set nums = new HashSet();
        nums.add(1);
        nums.add(2);
        nums.add(3);

        conjunto.addAll(nums); //Adiciona dentro de conjunto todos os valores de nums

        conjunto.retainAll(nums); //Mantém em conjunto apenas o que exitir em conjunto e em nums

        conjunto.clear(); // Remove todos elementos

    }
    
}
