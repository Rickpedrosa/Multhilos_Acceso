package Multihilo.Ejercicio_sleepHora;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread hiloSecund = new Thread(new Hora());
        (hiloSecund).start();
        hiloSecund.join();
        System.out.println("Han pasado 20 segundos.");
    }

}
