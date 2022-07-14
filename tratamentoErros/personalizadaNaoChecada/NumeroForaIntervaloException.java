package tratamentoErros.personalizadaNaoChecada;

public class NumeroForaIntervaloException extends RuntimeException {
  
  private String nomeDomeAtributo;

  public NumeroForaIntervaloException(String nomeDomeAtributo) {
    this.nomeDomeAtributo = nomeDomeAtributo;
  }

  public String getMessage() {
    return String.format("O atributo '%s' está negativo!", nomeDomeAtributo);
  }

}
