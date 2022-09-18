package padroes.observer;

public class Namorada implements ObservadorChegadaAniversariante {

    public void chegou(EventoChegadaAniversariante evento) {
        System.out.println("Surpresa!");
    }
    
}
