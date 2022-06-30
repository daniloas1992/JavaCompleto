package lambdas.interfacesFuncionais2;

public class Produto {

  public final String nome;
  public final double preco;
  public final double desconto;

  public Produto(String nome, double preco, double desconto) {
    this.nome = nome;
    this.preco = preco;
    this.desconto = desconto;
  }

  @Override
  public String toString() {
    return nome + " tem preço de " + preco * (1 - desconto);
  }
  
}
