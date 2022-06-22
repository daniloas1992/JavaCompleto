package lambdas.interfacesFuncionais2;

public class Produto {

  final String nome;
  final double preco;
  final double desconto;

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
