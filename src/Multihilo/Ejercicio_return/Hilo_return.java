package Multihilo.Ejercicio_return;

public class Hilo_return implements Runnable {

    private int value;
    private double fact;

    public Hilo_return(int value) {
        this.value = value;
    }

    @Override
    public void run() {
        fact = 1;
        for (int i = value; i > 0; i--) {
            fact = fact * i;
        }

    }

    public double getValue() {
        return fact;
    }
}
