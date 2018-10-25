package src.Multihilo.Ejercicio_cine;

//realizar un programa multihilo que gestione un cine con 6 salas
//mediante una clase cine que contiene un array con el num de salas disponibles en cada sala
//el hilo principal debe crear tantos hilos como taquillas tiene el cine que son 3
//el comportamiento de cada taquilla es diferente, dado que representa las compras
// y devoluciones de entradas de los usuarios
//cuando las 3 taquillas cierran el hilo principal debe mostrar cuantas personas han acudido a cada sala

public class Cine {
    private int[] salas;
    private Object[] revisor;
    private int butacasize;
    private int[] p;

    public Cine() {
        butacasize = 100;
        salas = new int[6];
        revisor = new Object[6];
        p = new int[6];
        for (int i = 0; i < salas.length; i++) {
            salas[i] = butacasize;
            revisor[i] = 1;
            p[i] = 0;
        }
    }

    public void comprarButaca(int entradas, int pos) {
        if (salas[pos] > 0 && salas[pos] <= butacasize) {
            synchronized (revisor[pos]) {
                salas[pos] = salas[pos] - entradas;
                p[pos] += entradas;
            }
        }
    }

    public void dejarButaca(int entradas, int pos) {
        if (salas[pos] < butacasize && salas[pos] > 0) {
            synchronized (revisor[pos]) {
                salas[pos] = salas[pos] + entradas;
            }
        }
    }


    public void getPersonasxSala() {
        for (int i = 0; i < salas.length; i++) {
            System.out.printf("A la sala %d han acudido %d personas\n", i + 1, p[i]);
        }
    }
}