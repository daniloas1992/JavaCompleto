package generics;

import java.util.Objects;

public class Par<C, V> {

    private C chave;
    private V valor;

    public Par() {}

    public Par(C chave, V valor) {
        super();
        this.chave = chave;
        this.valor = valor;
    }

    public C getChave() {
        return this.chave;
    }

    public void setChave(C chave) {
        this.chave = chave;
    }

    public V getValor() {
        return this.valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Par)) {
            return false;
        }
        Par<?,?> par = (Par<?,?>) o;
        return Objects.equals(chave, par.chave);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chave);
    }
    
}
