package generics;

public class CaixaTeste {
    
    public static void main(String[] args) {
        
        Caixa<String> caixaA = new Caixa<>();
        caixaA.guardar("coisa");
        System.out.println(caixaA.abrir());

        Caixa<Double> caixaB = new Caixa<>();
        caixaB.guardar(2.5);
        System.out.println(caixaB.abrir());

    }
}
