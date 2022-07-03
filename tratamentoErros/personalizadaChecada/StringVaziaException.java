package tratamentoErros.personalizadaChecada;

public class StringVaziaException extends Exception {
  
  private String nomeDomeAtributo;

  public StringVaziaException(String nomeDomeAtributo) {
    this.nomeDomeAtributo = nomeDomeAtributo;
  }

  public String getMessage() {
    return String.format("O atributo '%s' está vazio!", nomeDomeAtributo);
  }

}
