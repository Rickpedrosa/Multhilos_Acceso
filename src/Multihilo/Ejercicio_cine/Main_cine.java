package src.Multihilo.Ejercicio_cine;

public class Main_cine {
    public static void main(String[] args) {
        Cine cinema = new Cine();
        Thread h1 = new Thread(new Taquilla_currante1(cinema));
        Thread h2 = new Thread(new Taquilla_currante1(cinema));
        Thread h3 = new Thread(new Taquilla_currante1(cinema));

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

        cinema.getPersonasxSala();
    }
}
