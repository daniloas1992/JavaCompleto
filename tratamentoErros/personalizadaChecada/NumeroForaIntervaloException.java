package tratamentoErros.personalizadaChecada;

public class NumeroForaIntervaloException extends Exception {
  
  private String nomeDomeAtributo;

  public NumeroForaIntervaloException(String nomeDomeAtributo) {
    this.nomeDomeAtributo = nomeDomeAtributo;
  }

  public String getMessage() {
    return String.format("O atributo '%s' está negativo!", nomeDomeAtributo);
  }

}
