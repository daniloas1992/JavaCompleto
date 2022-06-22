package arraysCollections.equals;

public class Usuario {
    
    String nome;
    String email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof Usuario)) {
            return false;
        }

        Usuario outro = (Usuario) obj;

        return outro.nome.equals(this.nome) && outro.email.equals(this.email);
    }

}
