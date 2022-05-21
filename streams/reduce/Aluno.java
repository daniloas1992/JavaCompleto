package streams.reduce;

import java.util.Objects;

public class Aluno {

  final String nome;
  final public double nota;

  public Aluno(String nome, double nota) {
    this.nome = nome;
    this.nota = nota;
  }

  public String toString() {
    return nome + " tem nota " + nota;
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

}
