package Multihilo.Ejercicio_syncro;

public class Tropas {

    private double soldados;
    private Object vigilante;

    public Tropas(double soldados) {
        this.soldados = soldados;
    }

    public double getSoldados() {
        return soldados;
    }

    public void setSoldados(double soldados) {
        this.soldados = soldados;
    }

    public void reclutar(double leva) {
        synchronized (vigilante) {
            soldados += leva;
        }
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public void reclutarUnsyn(double leva) {
        soldados += leva;
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}
