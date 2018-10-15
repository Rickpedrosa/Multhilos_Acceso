package src.Multihilo.Ejercicio_syncro;

public class Tropas {

    private double soldados;

    public Tropas(double soldados) {
        this.soldados = soldados;
    }

    public double getSoldados() {
        return soldados;
    }

    public void setSoldados(double soldados) {
        this.soldados = soldados;
    }

    public synchronized void reclutar(double leva){
        soldados += leva;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void reclutarUnsyn(double leva){
        soldados += leva;
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}
