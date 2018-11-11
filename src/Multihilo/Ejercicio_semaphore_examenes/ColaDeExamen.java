package Multihilo.Ejercicio_semaphore_examenes;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ColaDeExamen {
    private Semaphore semaforoTurno;
    private boolean[] isPCDisponible;
    private Lock pedro;
    private Random tiempoExamen = new Random();

    public ColaDeExamen() {
        int ORDENADORES_LIBRES = 5;
        semaforoTurno = new Semaphore(ORDENADORES_LIBRES);
        isPCDisponible = new boolean[ORDENADORES_LIBRES];
        for (int i = 0; i < isPCDisponible.length; i++) {
            isPCDisponible[i] = true;
        }
        pedro = new ReentrantLock();
    }

    public void hacerExamen() {
        try {
            semaforoTurno.acquire();
            String alumnoActual = Thread.currentThread().getName();
            int tiempo = tiempoExamen.nextInt(5);
            int pc = cogerPC();
            System.out.printf("Alumno %s comienza el examen en el ordenador %d\n", alumnoActual, pc);
            TimeUnit.SECONDS.sleep(tiempo);

            isPCDisponible[pc] = true;

            System.out.printf("Alumno %s termina el examen en el ordenador %d\n", alumnoActual, pc);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforoTurno.release();
        }
    }

    private int cogerPC() {
        int pc = -1;

        try {
            pedro.lock();
            for (int i = 0; i < isPCDisponible.length; i++) {
                if (isPCDisponible[i]) {
                    pc = i;
                    isPCDisponible[i] = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pedro.unlock();
        }

        return pc;
    }
}
