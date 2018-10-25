package Multihilo.Ejercicio_cine.xd;

public class Main {
//    realizar un programa multihilo que gestione un cine con 6 salas
//    mediante una clase cine que contiene un array con el numero de butacas disponibles
//    en cada sala.
//    El hilo principa debe crear tantos hilos como taquillas tiene el cine, que
//    son 3. El comportamiento de cada taquilla es diferente, dado que representa las compras y
//    devoluciones de entradas de los usuarios.

    public static void main(String[] args) {
        Cine cine = new Cine();
        System.out.println(cine.toString());
        Thread hilo1 = new Thread(new Taquilla(cine));
        Thread hilo2 = new Thread(new Taquilla(cine));
        Thread hilo3 = new Thread(new Taquilla(cine));

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(cine.toString());
    }
}
