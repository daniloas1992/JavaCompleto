package arraysCollections.hash;

import java.util.Objects;

public class Usuario {
    
    String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(nome, usuario.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

}
