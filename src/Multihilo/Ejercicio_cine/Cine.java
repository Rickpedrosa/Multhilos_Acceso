package src.Multihilo.Ejercicio_cine;

//realizar un programa multihilo que gestione un cine con 6 salas
//mediante una clase cine que contiene un array con el num de butacas disponibles en cada sala
//el hilo principal debe crear tantos hilos como taquillas tiene el cine que son 3
//el comportamiento de cada taquilla es diferente, dado que representa las compras
// y devoluciones de entradas de los usuarios
//cuando las 3 taquillas cierran el hilo principal debe mostrar cuantas personas han acudido a cada sala

public class Cine {
    private int[] butacas;
    private Object[] revisor;
    private int butacasize;
    private int[] personas;

    public Cine() {
        butacasize = 100;
        butacas = new int[6];
        revisor = new Object[6];
        personas = new int[6];
        for (int i = 0; i < butacas.length; i++) {
            butacas[i] = butacasize;
            revisor[i] = 1;
        }
    }

    public void comprarButaca(int entradas, int pos_sala) {
        synchronized (revisor[pos_sala]) {
            if (butacas[pos_sala] > 0) {
                butacas[pos_sala] = butacas[pos_sala] - entradas;
                personas[pos_sala] += entradas;
            }
            if (personas[pos_sala] > butacasize) {
                personas[pos_sala] = personas[pos_sala] + butacas[pos_sala];
                butacas[pos_sala] = 0;
            }
        }

    }

    public void dejarButaca(int entradas, int pos_sala) {
        synchronized (revisor[pos_sala]) {
            if (butacas[pos_sala] < butacasize) {
                butacas[pos_sala] = butacas[pos_sala] + entradas;
                personas[pos_sala] -= entradas;
            }
            if (personas[pos_sala] < 0) {
                personas[pos_sala] = 0;
                butacas[pos_sala] = butacasize;
            }
        }
    }


    public void getPersonasxSala() {
        for (int i = 0; i < butacas.length; i++) {
            System.out.printf("A la sala %d han acudido %d personas || Butacas libres: %d\n", i + 1, personas[i], butacas[i]);
        }
    }
}