package Multihilo.ejercicio_countDownLash;

import java.util.concurrent.CountDownLatch;

public class Conferencia implements Runnable {

    private CountDownLatch berlinWall;
    private int maxAsistentes;

    public Conferencia(int maxAsistentes) {
        this.maxAsistentes = maxAsistentes;
    }

    @Override
    public void run() {

    }
}
