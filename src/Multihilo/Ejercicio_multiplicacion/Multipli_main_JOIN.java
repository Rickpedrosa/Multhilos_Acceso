package Multihilo.Ejercicio_multiplicacion;

import java.util.ArrayList;

public class Multipli_main_JOIN {

    public static void main(String[] args) throws InterruptedException {

        Thread[] threadStore = new Thread[10];

        for (int i = 1; i <= 10; i++) {
            threadStore[i] = (new Thread(new Multiplicacion(i)));
            threadStore[i].start();
        }

        for (int i = 1; i <= 10; i++) {
            threadStore[i].join();
        }

        System.out.println("yasta");
    }
}
