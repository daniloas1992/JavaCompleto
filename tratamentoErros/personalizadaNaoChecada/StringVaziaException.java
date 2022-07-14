package tratamentoErros.personalizadaNaoChecada;

public class StringVaziaException extends RuntimeException {
  
  private String nomeDomeAtributo;

  public StringVaziaException(String nomeDomeAtributo) {
    this.nomeDomeAtributo = nomeDomeAtributo;
  }

  public String getMessage() {
    return String.format("O atributo '%s' está vazio!", nomeDomeAtributo);
  }

}
