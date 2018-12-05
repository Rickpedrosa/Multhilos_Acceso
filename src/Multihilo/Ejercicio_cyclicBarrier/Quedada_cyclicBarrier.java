package Multihilo.Ejercicio_cyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Quedada_cyclicBarrier {

    private static final int NUMERO_COLEGAS = 5;
    private Random tiempo = new Random();
    private CyclicBarrier barrera;

    public Quedada_cyclicBarrier() {
    }

    public void salirDeFiesta(String nombreFulano) throws InterruptedException {
        System.out.printf("%s ha salido de casa", nombreFulano);
        int time = tiempo.nextInt(5);
        TimeUnit.SECONDS.sleep(time);

        try {
            barrera.await((long) time, TimeUnit.SECONDS);
        } catch (BrokenBarrierException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
