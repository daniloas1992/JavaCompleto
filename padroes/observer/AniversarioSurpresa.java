package padroes.observer;

public class AniversarioSurpresa {

    public static void main(String[] args) {
        
        Namorada namorada = new Namorada();
        Porteiro porteiro = new Porteiro();

        porteiro.registrarObservador(namorada);

        porteiro.registrarObservador(evento -> System.out.println("Surpresa via lmabda! Em " + evento.getMomento()));

        porteiro.monitorar();

    }
}
