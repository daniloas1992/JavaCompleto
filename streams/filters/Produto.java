package streams.filters;

public class Produto {
  
  final String descricao;
  final double valor;
  final double desconto;
  final boolean temImposto;
  final boolean temFrete;

  public Produto(String descricao, double valor, double desconto, boolean temImposto, boolean temFrete) {
    this.descricao = descricao;
    this.valor = valor;
    this.desconto = desconto;
    this.temImposto = temImposto;
    this.temFrete = temFrete;
  }

}
