package arraysCollections.hash;

import java.util.HashSet;

public class Hash {

    public static void main(String[] args) {
        
        HashSet<Usuario> usuarios = new HashSet<Usuario>();
        usuarios.add(new Usuario("Ana"));
        usuarios.add(new Usuario("Pedro"));
        usuarios.add(new Usuario("Lucas"));

        // Retorna true pois o equals e hashcode foi sobreecrito na classe de usuário
        System.out.println(usuarios.contains(new Usuario("Lucas")));

    }
    
}
