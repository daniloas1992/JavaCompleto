package arraysCollections.collections;

import java.util.HashSet;
import java.util.Set;

public class SetHomogeneo {

    public static void main(String[] args) {
        
        // HashSet não mantém ordem de inserção
        Set<String> lista = new HashSet<String>();
        lista.add("Ana");
        lista.add("Bruno");
        lista.add("Carlos");
        lista.add("Maria");
        lista.add("Pedro");

        // TreeSet mantém ordem de inserção: SortedSet<String> lista = new TreeSet<String>();
        Set<String> lista2 = new HashSet<String>();
        lista2.add("Ana");
        lista2.add("Bruno");
        lista2.add("Carlos");
        lista2.add("Maria");
        lista2.add("Pedro");


    }
    
}
