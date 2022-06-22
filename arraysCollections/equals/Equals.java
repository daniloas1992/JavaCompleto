package arraysCollections.equals;

public class Equals {
     public static void main(String[] args) {
         
        Usuario u1 = new Usuario("Pedro", "pedro@email.com");
        Usuario u2 = new Usuario("Pedro", "pedro@email.com");

        System.out.println(u1==u2); // False
        System.out.println(u1.equals(u2)); // Se Usuário não sobreescrever equals retorna False

     }
}
