package tratamentoErros.personalizadaNaoChecada;

import java.util.Objects;

public class Aluno {
  
  public final String nome;
  public final double nota;


  public Aluno(String nome, double nota) {
    this.nome = nome;
    this.nota = nota;
  }

  @Override
  public String toString() {
    return nome + " tem note " + nota;
  }


  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Aluno)) {
            return false;
        }
        Aluno aluno = (Aluno) o;
        return Objects.equals(nome, aluno.nome) && nota == aluno.nota;
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, nota);
  }


}
