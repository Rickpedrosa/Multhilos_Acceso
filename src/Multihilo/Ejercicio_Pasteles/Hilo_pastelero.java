package src.Multihilo.Ejercicio_Pasteles;

public class Hilo_pastelero implements Runnable {

    private Bandeja bandejaDonuts;

    public Hilo_pastelero(Bandeja bandejaDonuts) {
        this.bandejaDonuts = bandejaDonuts;
    }

    @Override
    public void run() {
        //bandejaDonuts.addDonut();
    }
}
