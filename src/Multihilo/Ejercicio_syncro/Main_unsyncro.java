package src.Multihilo.Ejercicio_syncro;

public class Main_unsyncro {
    public static void main(String[] args) {
        double resultado;
        Tropas trp = new Tropas(0);
        HiloCurrante work = new HiloCurrante(trp);
        Thread h1 = new Thread(work);
        Thread h2 = new Thread(work);
        Thread h3 = new Thread(work);

        h1.start();
        h2.start();
        h3.start();

        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(trp.getSoldados());
    }
}
