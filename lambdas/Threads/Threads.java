package lambdas.Threads;

public class Threads {

  public static void main(String[] args) {

    Runnable trabalho = Threads::trabalho;

    Thread t = new Thread(trabalho);
    t.start();

  }

  static void trabalho() {
    for(int i =0; i<10; i++) {
      System.out.println("Executando tarefa");
      try {
        Thread.sleep(100);
      } catch (Exception e) {
        System.out.println("Erro!");
      }
    }
  }
}
