package generics;

public class ParesTeste {

    public static void main(String[] args) {
        
        Pares<Integer, String> resultadoConcurso = new Pares<>();

        resultadoConcurso.adicionar(1, "Maria");
        resultadoConcurso.adicionar(2, "Pedro");
        resultadoConcurso.adicionar(3, "José");
        resultadoConcurso.adicionar(4, "Lucas");
        resultadoConcurso.adicionar(2, "Rodrigo");

        System.out.println(resultadoConcurso.getValor(1));
        System.out.println(resultadoConcurso.getValor(4));
        System.out.println(resultadoConcurso.getValor(2));

    }
    
}
