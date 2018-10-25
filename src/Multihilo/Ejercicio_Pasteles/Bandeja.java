package src.Multihilo.Ejercicio_Pasteles;

import java.util.ArrayList;
import java.util.List;

public class Bandeja {

    private List<Donut> losDonuts = new ArrayList<>();
    private Donut donuts;

    public Bandeja(Donut donuts) {
        this.donuts = donuts;
    }

    public synchronized int getBandejaSize() {
        return losDonuts.size();
    }

    public synchronized void addDonut(Donut donut, String nombrePastelero) {
        if (losDonuts.size() < 10) {
            losDonuts.add(donut);
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void removeDonut(Donut donut, String nombreGloton) {
        if (losDonuts.size() > 0) {
            losDonuts.remove(donut);
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
