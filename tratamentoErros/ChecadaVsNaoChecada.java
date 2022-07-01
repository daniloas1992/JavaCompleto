package tratamentoErros;

public class ChecadaVsNaoChecada {
    
    public static void main(String[] args) {


        try{
            gerarErro1();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try{
            gerarErro2();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Fim!");
    }

    // Exceção NÃO checada ou NÃO verificada: RuntimeException ou classes filhas 
    static void gerarErro1() {
        throw new RuntimeException("Gerou Erro #1");
    }

    // Exceção checada ou verificada: Quem chamar o método precisa tratar o erro
    static void gerarErro2() throws Exception {
        throw new Exception("Gerou Erro #2");
    }

}
